import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1948 {

    static class City {
        int node;
        int cost;

        public City(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static boolean[] visited;
    static int[] result;
    static int[] inOut;
    static List<City>[] list;
    static List<City>[] reverse_list;
    static List<int[]> cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        inOut = new int[n + 1];
        result = new int[n + 1];
        visited = new boolean[n+1];
        list = new List[n+1];
        reverse_list = new List[n+1];
        
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverse_list[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new City(e, cost));
            reverse_list[e].add(new City(s, cost));
            inOut[e]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        polSort(sCity);
        int resultCount= rePolSort(eCity);
        System.out.println(result[eCity]);
        System.out.println(resultCount);

    }

    static void polSort(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (City next : list[curr]) {
                inOut[next.node]--;
                result[next.node] = Math.max(result[next.node], result[curr] + next.cost);
                if (inOut[next.node] == 0) {
                    que.add(next.node);
                }
            }
        }
    }


    static int rePolSort(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;
        int resultCount=0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (City next : reverse_list[curr]) {
                if(result[next.node] + next.cost == result[curr]){
                    resultCount++;
                    if(!visited[next.node]){
                        visited[next.node] = true;
                        que.add(next.node);
                    }
                }
            }
        }

        return resultCount;
    }





}

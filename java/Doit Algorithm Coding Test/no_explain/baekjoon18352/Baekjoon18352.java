import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon18352 {

    static List<Integer>[] list;
    static int findCount;
    static List<Integer> answer;
    static boolean[] visited;

    static class Location{
            int node;
            int dept;

            public Location(int node, int dept) {
                this.node = node;
                this.dept = dept;
            }
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findCount = arr[2];
        answer = new ArrayList<>();
        list = new List[arr[0] + 1];
        visited = new boolean[arr[0] + 1];

        for (int i = 0; i <= arr[0]; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr[1]; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sNode = Integer.parseInt(st.nextToken());
            int eNode = Integer.parseInt(st.nextToken());
            list[sNode].add(eNode);
        }

        solve(arr[3]);
        answer.sort(Comparator.naturalOrder());
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i : answer) {
                System.out.println(i);
            }
        }
    }

    private static void solve(int city) {
        Queue<Location> que = new ArrayDeque<>();
        que.add(new Location(city, 0));
        visited[city] = true;
        while (!que.isEmpty()) {
            Location curr = que.poll();
            if(curr.dept == findCount){
                answer.add(curr.node);
            }
            for (Integer next : list[curr.node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(new Location(next, curr.dept+1));
                }
            }
        }
    }
}

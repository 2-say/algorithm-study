import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1219 {

    static List<Node> list;
    static long[] dist;
    static int n;

    static int[] earnMoney;

    static class Node {
        int sCity;
        int eCity;
        int cost;

        public Node(int sCity, int eCity, int cost) {
            this.sCity = sCity;
            this.eCity = eCity;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 수
        int s = Integer.parseInt(st.nextToken()); // 시작 도시
        int e = Integer.parseInt(st.nextToken()); // 도착 도시
        int edge = Integer.parseInt(st.nextToken()); // 간선 수

        dist = new long[n];
        //처음에 MIN값으로 초기화 왜냐하면, 나는 최장으로 많이 번 돈을 얻기 위해서
        Arrays.fill(dist, Long.MIN_VALUE);
        list = new ArrayList<>();

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, cost));
        }

        earnMoney = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        bellman(s, e);
    }

    static void bellman(int start, int end) {
        //시작은 무조건 방문하므로 번다.
        dist[start] = earnMoney[start];

        // n+100인 이유는 양수사이클을 모두 표시해주기 위해서 
        for (int i = 0; i < n+100; i++) {

            //모든 간선 방문한다.
            for (Node node : list) {

                //한번도 업데이트 되지 않았다. (출발지점은 LONG.MIN_VALUE이 아님)
                if (dist[node.sCity] == Long.MIN_VALUE)
                    continue;
                  
                else if (dist[node.sCity] == Long.MAX_VALUE)
                    dist[node.eCity] = Long.MAX_VALUE;
                
                //출발지점에서 (얻는 비용 - 이동비용)이 최대로 만들기 위해서
                else if ( dist[node.eCity] < dist[node.sCity] + earnMoney[node.eCity] - node.cost) {
                    dist[node.eCity] = dist[node.sCity] + earnMoney[node.eCity] - node.cost;
                    if (i >= n - 1)
                        //만약 n-1까지 했는데, 양수 사이클이 있다는 뜻이다.
                        dist[node.eCity] = Long.MAX_VALUE;
                }
            }
        }

        //도착할 수 없는 도시라는 뜻
        if (dist[end] == Long.MIN_VALUE) System.out.println("gg");
        //양수 싸이클이다.
        else if(dist[end] == Long.MAX_VALUE) System.out.println("Gee");
        //그게 아니라면 벌수있는 값을 출력
        else
            System.out.println(dist[end]);
    }
}

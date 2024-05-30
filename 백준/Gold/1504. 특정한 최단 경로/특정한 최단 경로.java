import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int E;
    static int min;
    static List<Cost> edges[];
    static boolean[] visited;
    static int[][] costMap;
    static int INF = 200000000;

    static class Cost implements Comparable<Cost> {
        int node;
        int cost;

        public Cost(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cost o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 양방향
            edges[a].add(new Cost(b, cost));
            edges[b].add(new Cost(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        costMap = new int[N + 1][N + 1];
        min = Integer.MAX_VALUE;

        // 초기화
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                costMap[i][j] = INF;
            }
        }

        dijkstra(1);
        dijkstra(v1);
        dijkstra(v2);

        long answer = 0;
        answer = Math.min(costMap[1][v2] + costMap[v2][v1] + costMap[v1][N],
                costMap[1][v1] + costMap[v1][v2] + costMap[v2][N]);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dijkstra(int start) {
        Queue<Cost> que = new PriorityQueue<>();
        visited = new boolean[N + 1];

        que.add(new Cost(start, 0));
        costMap[start][start] = 0;

        while (!que.isEmpty()) {
            Cost curr = que.poll();

            if (visited[curr.node])
                continue;
            visited[curr.node] = true;

            for (Cost next : edges[curr.node]) {
                if (costMap[start][next.node] > costMap[start][curr.node] + next.cost) {
                    costMap[start][next.node] = costMap[start][curr.node] + next.cost;
                    que.add(new Cost(next.node, costMap[start][next.node]));
                }
            }
        }
    }
}
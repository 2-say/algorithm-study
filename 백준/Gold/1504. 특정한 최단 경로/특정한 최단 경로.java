import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int N;
    static int E;
    static int min;
    static List<Cost> edges[];
    private static int INF = 200000000;
    static int[] costMap;

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

        costMap = new int[N + 1];
        min = Integer.MAX_VALUE;

        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        int Ans = 0;
        if (ans1 >= INF && ans2 >= INF)
            Ans = -1;
        else
            Ans = Math.min(ans1, ans2);

        System.out.println(Ans);

    }

    public static int dijkstra(int start, int end) {
        visited = new boolean[N + 1];
        Arrays.fill(costMap, INF);

        Queue<Cost> que = new PriorityQueue<>();
        que.add(new Cost(start, 0));
        costMap[start] = 0;

        while (!que.isEmpty()) {
            Cost curr = que.poll();

            if (visited[curr.node]) continue;
            visited[curr.node] = true;

            for (Cost next : edges[curr.node]) {
                // 다음노드
                if (costMap[next.node] > costMap[curr.node] + next.cost) {
                    costMap[next.node] = costMap[curr.node] + next.cost;
                    que.add(new Cost(next.node, costMap[next.node]));
                }
            }
        }
        return costMap[end];
    }
}
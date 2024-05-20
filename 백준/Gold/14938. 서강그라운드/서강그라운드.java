import java.io.*;
import java.util.*;

class Main {

    static boolean[] visited;
    static List<E>[] edges;
    static int[] points;
    static int n;
    static int m; // 수색범위
    static int[] dis;

    static class E implements Comparable<E> {
        int cost;
        int node;

        public E(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public int compareTo(Main.E o) {
            return Integer.compare(cost, o.cost);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드 개수
        m = Integer.parseInt(st.nextToken()); // 수색범위
        int r = Integer.parseInt(st.nextToken()); // 간선 개수

        edges = new List[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        points = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            // 양방향
            edges[s].add(new E(cost, e));
            edges[e].add(new E(cost, s));
        }

        // 모든 노드에서 출발
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);

            int result = dijkstra(i);

            if (max < result) {
                max = result;
            }
        }

        System.out.println(max);
    }

    static int dijkstra(int startN) {
        Queue<E> que = new PriorityQueue();

        int result = points[startN];
        que.add(new E(0, startN));
        dis[startN] = 0;

        while (!que.isEmpty()) {
            E curr = que.poll();

            for (E next : edges[curr.node]) {
                if (next.cost + dis[curr.node] < dis[next.node]) {
                    dis[next.node] = next.cost + dis[curr.node];
                    que.add(new E(dis[next.node], next.node));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dis[i] <= m && i != startN) {
                result += points[i];
            }
        }

        return result;
    }

}
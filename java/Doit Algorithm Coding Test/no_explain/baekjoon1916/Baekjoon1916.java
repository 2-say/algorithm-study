import java.io.*;
import java.util.*;

class Baekjoon1916 {

    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        list = new List[v + 1];
        dist = new int[v + 1];
        visited = new boolean[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[s].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikstra(start);
        System.out.println(dist[end]);
    }

    static void dikstra(int start) {
        Queue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        dist[start] = 0;

        while (!que.isEmpty()) {
            Node curr = que.poll();
            if (!visited[curr.n]) {
                visited[curr.n] = true;
                for (Node next : list[curr.n]) {
                    if (!visited[next.n] && dist[next.n] > curr.cost + next.cost) {
                        dist[next.n] = curr.cost + next.cost;
                        que.add(new Node(next.n, dist[next.n]));
                    }
                }
            }
        }
    }
}
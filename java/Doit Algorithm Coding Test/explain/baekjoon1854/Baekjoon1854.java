import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon1854 {
    static List<Node>[] list;
    static boolean[] visited;
    static Queue<Integer>[] result;
    static int k;

    static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result = new Queue[v + 1];
        list = new List[v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
            result[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node(end, cost));
        }

        dijkstra(1);

        for (int i = 1; i <= v; i++) {
            if (result[i].size() == k) {
                System.out.println(result[i].peek());
            } else {
                System.out.println(-1);
            }
        }

    }

    static void dijkstra(int start) {
        Queue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        result[start].add(0);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (Node next : list[cur.n]) {
                if (result[next.n].size() < k) {
                    result[next.n].add(cur.cost + next.cost);
                    que.add(new Node(next.n, cur.cost + next.cost));
                } else {
                    if (cur.cost + next.cost< result[next.n].peek()) {
                        result[next.n].poll();
                        result[next.n].add(cur.cost + next.cost);
                        que.add(new Node(next.n, cur.cost + next.cost));
                    }
                }

            }
        }
    }
}

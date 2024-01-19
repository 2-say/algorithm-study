import java.io.*;
import java.util.*;

public class Baekjoon1753 {

    static List<Node>[] nLists;
    static int[] dis;

    static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        nLists = new ArrayList[v + 1];

        for (int i = 1; i <= v ; i++) {
            nLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nLists[s].add(new Node(end, cost));
        }

        dikstra(start);

        for (int i = 1; i <= v; i++) {
            if (dis[i] != Integer.MAX_VALUE)
                System.out.println(dis[i]);
            else
                System.out.println("INF");
        }
    }

    static void dikstra(int start) {
        Queue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        dis[start] = 0;
    
        while (!que.isEmpty()) {
            Node curr = que.poll();

            for (Node next : nLists[curr.n]) {
                 if (curr.cost + next.cost < dis[next.n]){
                    dis[next.n] = curr.cost + next.cost;
                    que.add(new Node(next.n, curr.cost + next.cost));
                 }
            }
        }
    }
}
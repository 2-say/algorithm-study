import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] list;
    static long[] dist;
    static int n;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node(end, cost));
        }
        bellman(1);
    }

    static void bellman(int s) {
        dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        boolean cycle = false;
        //n까지 반복 (n인상태에서 업데이트 되면 싸이클)
        for (int j = 0; j < n; j++) {
            //모든 노드를 탐색하기 위한 반복문
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    //모든 간선 탐색
                    for (Node next : list[i]) {
                        //업데이트 과정
                        if (dist[next.n] > dist[i] + next.cost) {
                            dist[next.n] = dist[i] + next.cost;
                            if (j == n-1) {
                                cycle = true;
                            }
                        }
                    }
                }
            }
        }
        if (!cycle) {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE)
                    System.out.println(-1);
                else
                    System.out.println(dist[i]);
            }
        } else {
            System.out.println(-1);
        }
    }
}

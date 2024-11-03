import java.io.*;
import java.util.*;

class Main {

    static List<Node>[] nList;
    static int N, M;

    static class Node {
        int e, cost;

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        nList = new List[N + 1];  // 1부터 시작한다고 가정하여 N+1로 설정

        for (int i = 0; i <= N; i++) {
            nList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nList[u].add(new Node(v, cost));
            nList[v].add(new Node(u, cost));  // 양방향 연결
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, end));
        }
    }

    static int bfs(int s, int e) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new Node(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.e == e) {
                return current.cost;
            }

            for (Node neighbor : nList[current.e]) {
                if (!visited[neighbor.e]) {
                    visited[neighbor.e] = true;
                    q.add(new Node(neighbor.e, current.cost + neighbor.cost));
                }
            }
        }

        return -1; // 경로가 없는 경우 (실제로는 항상 경로가 있다고 가정하면 필요 없음)
    }
}

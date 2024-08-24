import java.io.*;
import java.util.*;

class Main {

    static int[] dis;
    static int[] answer;
    static List<Node>[] map;

    static class Node implements Comparable<Node>{
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        map = new List[N];

        for(int i = 0; i < N; i++) map[i] = new ArrayList();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            map[A].add(new Node(B, cost));
        }

        answer = new int[N];

        for(int i = 0; i < N; i++) {
            dis = new int[N];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dijkstra(i);
            answer[i] = dis[X-1];
        }
        
        dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(X-1);

        for(int i = 0 ; i < answer.length; i++)
            answer[i] += dis[i];

        Arrays.sort(answer);
        System.out.println(answer[answer.length-1]);
    }

    static void dijkstra(int start) {
        Queue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        dis[start] = 0;

        while(!que.isEmpty()) {
            Node cur = que.poll();

            for(Node next : map[cur.n]) {
                if(next.cost + dis[cur.n] < dis[next.n]) {
                    dis[next.n] = next.cost + dis[cur.n];
                    que.add(new Node(next.n, dis[next.n]));
                }
            }
        }
    }
}
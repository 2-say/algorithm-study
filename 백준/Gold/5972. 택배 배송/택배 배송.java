import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<Edge>[] nList;
    static int[] dist;
    static final int MAX_VAL = Integer.MAX_VALUE;

    static class Edge {
        int v , cost;

        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nList = new List[N];
        for(int i = 0; i < N; i++) nList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            
            //양방향 간선
            nList[e].add(new Edge(v, cost));
            nList[v].add(new Edge(e, cost));
        }

        dist = new int[N];
        Arrays.fill(dist, MAX_VAL);
        dijkstra(0);

        System.out.println(dist[N-1]);
    }


    static void dijkstra(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);

        while(!q.isEmpty()) {
            Integer cur = q.poll();

            for(Edge next : nList[cur]) {
                if(dist[next.v] > dist[cur] + next.cost) {
                    dist[next.v] = dist[cur] + next.cost;
                    q.add(next.v);
                }
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Main {

    static int N, M, W;
    static List<Edge> eList;
    static int[] dist;
    static final int MAX_VALUE = 999_999;

    static class Edge {
        int w, v, cost;
        Edge(int w, int v, int cost) {
            this.w = w;
            this.v = v;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            eList = new ArrayList<>();
            dist = new int[N];
            
            for(int i = 0; i < N; i++) Arrays.fill(dist, MAX_VALUE);
            dist[0] = 0;

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());
                eList.add(new Edge(S,E,T));
                eList.add(new Edge(E,S,T));
            }

            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());
                eList.add(new Edge(S, E, -T));
            }
            
            sb.append(bellman()).append("\n");
        }
        System.out.println(sb);
    }

    static String bellman() {
        //n-1만큼 업데이트 진행한다.
        for(int i = 0; i < N-1; i++) {
            for(Edge e : eList) {
                if(dist[e.v] > dist[e.w] + e.cost) {
                    dist[e.v] = dist[e.w] + e.cost;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(Edge e : eList) {
                if(dist[e.v] > dist[e.w] + e.cost) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
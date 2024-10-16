import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[] union;
    static Queue<Edge> pq;
    static int[] visited;

    static class Edge {
        int e;
        int v;
        int cost;

        Edge(int e, int v, int cost) {
            this.e = e;
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        union = new int[N];
        visited = new int[N];
        for(int i = 0; i < N; i++) union[i] = i;

        pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.cost, o2.cost);
        });

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(e,v,cost));
        }

        solve();
    }   


    static void solve() {
        int answer = 0;
        int count = 0;
        while(count < N-2) {
            Edge next = pq.poll();
            if(findParent(next.e) != findParent(next.v)) {
                union(next.e, next.v); // 간선 연결
                answer += next.cost;
                count++;
            }
        }

        System.out.println(answer);
    }

    static int findParent(int idx) {
        if(union[idx] == idx) return idx;
        return union[idx] = findParent(union[idx]);
    }

    static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if(pa != pb) union[pa] = pb;
    }

}
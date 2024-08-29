import java.util.*;
import java.io.*;

class Main {

    static int[] dis;
    static List<Node>[] nList;
    static int V;
    static int E;
    static Map<Integer, Integer> path;
    static int arrive;
    static int start;
    static int[] parent;

    static class Node implements Comparable<Node> {
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
        E = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        nList = new List[E+1];
        dis = new int[E+1];
        parent = new int[E+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < E+1; i++) {
            nList[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nList[s].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        arrive = Integer.parseInt(st.nextToken());

        path = new HashMap<>();
        dijkstra();

        System.out.println(dis[arrive]);

        dfs(arrive);
    }

    static void dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        dis[start] = 0;

        while(!que.isEmpty()) {
            Node cur = que.poll();
 
            if(dis[cur.n] < cur.cost) continue;
            
            for(Node next : nList[cur.n]) {
                if(dis[next.n] > next.cost + dis[cur.n]) {
                    parent[next.n] = cur.n;
                    dis[next.n] = next.cost + dis[cur.n];
                    que.add(new Node(next.n, dis[next.n]));
                }
            }
        }
    }


    static void dfs(int s) {
        Stack<Integer> stac = new Stack();
        stac.add(s);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while(parent[s] != 0) {
            count++;
            stac.add(parent[s]);
            s = parent[s];
        }
        sb.append(count).append("\n");
        while(!stac.isEmpty()) {
            sb.append(stac.pop() + " ");
        }
        System.out.println(sb);
    }
}
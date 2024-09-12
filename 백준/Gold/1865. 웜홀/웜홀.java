import java.io.*;
import java.util.*;
 
public class Main {

    static List<Edge> nList;
    static int dis[];
    static boolean[] visited;

    static class Edge {
        int s;
        int e;
        int cost;

        Edge(int s,int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            nList = new ArrayList();
            
            for(int j = 0; j < M + W; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if(j < M) {
                    nList.add(new Edge(v,w,cost));
                    nList.add(new Edge(w,v,cost));
                } else {
                    nList.add(new Edge(v,w,-cost));
                }
            }

            String tmp = "NO";
            for(int k = 1 ; k <= N; k++) {
                dis = new int[N+1];
                Arrays.fill(dis, Integer.MAX_VALUE);
                if(bellManFord(N,M,k).equals("YES")){
                    tmp = "YES";
                    break;
                }
            }

            System.out.println(tmp);
        }
    }


    static String bellManFord(int N, int M, int start) {
        dis[start] = 0;
        boolean check;

        for(int i = 0; i < N; i++) {
            check = false;

            for(int j = 0; j < nList.size(); j++) {
                Edge eg = nList.get(j);

                if(dis[eg.s] != Integer.MAX_VALUE &&  dis[eg.e] > dis[eg.s] + eg.cost) {
                    dis[eg.e] = dis[eg.s] + eg.cost;
                    check = true;
                }
            }
            
            if(!check) break;
        }
       


        //한번 더 경로 업데이트가 일어나면 음수가중치가 있다.
        for(int j = 0; j < nList.size(); j++) {
            Edge eg = nList.get(j);

            if(dis[eg.s] != Integer.MAX_VALUE &&  dis[eg.e] > dis[eg.s] + eg.cost) {
                return "YES";
            }
        }

        return "NO";
    }
    
}
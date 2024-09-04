import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    
    static List<N>[] nList;
    static boolean[] visited;
    static int max;
    static int maxIdx;
    
    static class N {
        int e;
        int cost;

        N(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        nList = new List[N+1];
        for(int i = 0; i <= N; i++) {
            nList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int e = Integer.parseInt(in[1]);
            int cost = Integer.parseInt(in[2]);
            nList[s].add(new N(e,cost));
            nList[e].add(new N(s,cost));
        }
        
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[N+1];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.println(max);
    }


    static void dfs(int idx, int val) {
        if(max < val) {
            max = val;
            maxIdx = idx;
        }

        for(N next : nList[idx]) {
            if(!visited[next.e]) {
                visited[next.e] = true;
                dfs(next.e, val + next.cost);
            }
        }
    }
}
import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] ans;
    static List<Integer>[] nList;
    static int N, R, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //트리 정점 수
        R = Integer.parseInt(st.nextToken()) - 1; //루트 번호
        Q = Integer.parseInt(st.nextToken()); //쿼리의 수

        nList = new List[N];
        ans = new int[N];
        for(int i = 0; i < N; i++) nList[i] = new ArrayList<>();
        
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            nList[u].add(v);
            nList[v].add(u);
        }
        
        solve();

        for(int i = 0; i < Q; i++) { //쿼리 반복
            int c = Integer.parseInt(br.readLine()) - 1;
            System.out.println(ans[c]);
        }
    }

    static void solve() {
        visited = new boolean[N];
        dfs(R);
    }

    static int dfs(int cur) {
        if(ans[cur] != 0) return ans[cur];
        visited[cur] = true;
        int count = 1;

        for(int next : nList[cur]) {
            if(visited[next]) continue;
            count += dfs(next);
        }
        ans[cur] = count;

        return ans[cur];
    }
}
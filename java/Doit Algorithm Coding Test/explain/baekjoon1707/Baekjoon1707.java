import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1707 {

    static List<Integer>[] list;
    static boolean visited[];
    static int color[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new List[V + 1];
            visited = new boolean[V + 1];
            color = new int[V + 1];
            // 초기 =0; 빨강 = -1 , 파랑 = 1;
            
            for (int j = 0; j < V + 1; j++) {
                list[j] = new ArrayList<>();
            }

            for (int k = 0; k < E; k++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }

            boolean re = true;
            for (int l = 1; l <= V; l++) {
                if(!visited[l]){
                    Arrays.fill(color, 0);
                    if(!solve(l)){
                        re = false;
                        break;
                    }
                }
            }
            if(re) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean solve(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;
        color[start] = -1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            int nxColor = color[cur] * -1;
            for (int next : list[cur]) {
                if (color[next] != 0 && color[next] != nxColor) {
                    return false;
                }
                color[next] = nxColor;
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }

            }
        }
        return true;
    }
}

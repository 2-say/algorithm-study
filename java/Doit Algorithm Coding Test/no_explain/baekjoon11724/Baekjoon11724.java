import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Baekjoon11724 {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int edgeNum = Integer.parseInt(input[1]);

        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];
        int count = 0;

        for (int i = 0; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int start) {
        Stack<Integer> stac = new Stack<>();
        stac.add(start);
        while (!stac.isEmpty()) {
            int s = stac.pop();
            if(!visited[s]) {    
                visited[s] = true;
                for (int i : A[s]) {
                    stac.add(i);
                }
            }
        }
    }
}
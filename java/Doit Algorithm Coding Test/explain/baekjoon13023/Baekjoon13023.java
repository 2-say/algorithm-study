import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Baekjoon13023 {
    static boolean[] visited;
    private static ArrayList<Integer>[] list;
    static int n;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        list = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

        for (int i = 0; i < e; i++) {
            String[] f = br.readLine().split(" ");
            int a = Integer.parseInt(f[0]);
            int b = Integer.parseInt(f[1]);
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 0 ; i < n; i ++){
            if(!answer)
                dfs(i, 1);
        }
        if(answer) System.out.println("1");
        else System.out.println("0");
    }

    static void dfs(int start, int depth) {
        if(depth == 5){
            answer = true;
            return;
        }
        for(int i : list[start])
            if(!visited[i]){
                visited[start] = true;
                dfs(i,depth+1);
                visited[start] = false;
            }
    }
}
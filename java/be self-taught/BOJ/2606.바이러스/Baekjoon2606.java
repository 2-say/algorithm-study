import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baekjoon2606 {

    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        System.out.println(dfs(1));
    }

    public static long dfs(int start) {
        Stack<Integer> stac = new Stack<>();
        stac.add(start);
        visited[start] = true;
        long result = 0;
        while (!stac.isEmpty()) {
            int curr = stac.pop();
            if (!graph[curr].isEmpty()) {
                for (Integer integer : graph[curr]) {
                    int next = integer;
                    if (!visited[next]) {
                        visited[next] = true;
                        stac.push(next);
                        result++;
                    }
                }

            }
        }
        return result;
    }

}

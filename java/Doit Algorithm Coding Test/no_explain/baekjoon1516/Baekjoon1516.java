import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Baekjoon1516 {

    static List<Integer>[] list;
    static int[] inOut;
    static int[] time;
    static int[] ans;
    static boolean[] visited;
    static int accuTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new List[n + 1];
        inOut = new int[n + 1];
        time = new int[n + 1];
        ans = new int[n + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            time[i] = arr[0];
            if (arr.length > 2) {
                for (int j = 1; j < arr.length - 1; j++) {
                    list[arr[j]].add(i);
                    inOut[i]++;
                }
            }
        }

        accuTime = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && inOut[i] ==0)
                find(i);
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(ans[i]);
        }
    }

    static void find(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        visited[start] = true;
        que.add(start);
        ans[start] = time[start];
        
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int next : list[curr]) {
                inOut[next]--;
                ans[next] = Math.max(ans[next] , ans[curr] + time[next]);
                if (inOut[next] == 0 && !visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
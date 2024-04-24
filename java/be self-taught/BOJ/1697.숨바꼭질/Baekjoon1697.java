import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Baekjoon1697 {
    static int N;
    static int K;
    static boolean[] visited;

    static class Info {
        int count;
        int index;

        public Info(int count, int index) {
            this.count = count;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new boolean[100002];
        if (N == K)
            System.out.println(0);
        else
            solve(N);
    }

    public static void solve(int start) {
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(0, start));
        visited[start] = true;
        int min = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Info cur = que.poll();
            if (cur.index == K) {
                if (min > cur.count) {
                    min = cur.count;
                }
                continue;
            }

            if (cur.index * 1 < 100001 && !visited[cur.index + 1]) {
                visited[cur.index + 1] = true;
                que.add(new Info(cur.count + 1, cur.index + 1));
            }
            if (cur.index * 2 < 100001 && !visited[cur.index * 2]) {
                visited[cur.index * 2] = true;
                que.add(new Info(cur.count + 1, cur.index * 2));
            }
            if (cur.index >= 1 && !visited[cur.index - 1]) {
                visited[cur.index - 1] = true;
                que.add(new Info(cur.count + 1, cur.index - 1));
            }
        }
        System.out.println(min);
    }
}
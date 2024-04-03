import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon9019 {

    static final int MOD = 10000;
    static int findNum;
    static boolean[] visited;

    static class Info {
        StringBuilder command;
        int value;

        public Info(StringBuilder command, int value) {
            this.command = command;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int goodValue = Integer.parseInt(input[0]);
            findNum = Integer.parseInt(input[1]);
            visited = new boolean[10001];
            bfs(goodValue);
        }
    }

    public static String zero(String value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - value.length(); i++) {
            sb.append("0");
        }
        return sb.append(value).toString();
    }

    public static void bfs(int a) {
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(new StringBuilder(), a));

        while (!que.isEmpty()) {
            Info curr = que.poll();
            visited[curr.value] = true;

            if (curr.value == findNum) {
                System.out.println(curr.command.toString());
                break;
            } else {

                int D = curr.value * 2 % 10000;
                int S = (curr.value == 0) ? 9999 : curr.value - 1;
                int L = (curr.value % 1000) * 10 + curr.value / 1000;
                int R = (curr.value % 10) * 1000 + curr.value / 10;

                if (!visited[R]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr.command);
                    sb.append("R");
                    visited[R] = true;
                    que.add(new Info(sb, R));
                }

                if (!visited[L]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr.command);
                    sb.append("L");
                    visited[L] = true;
                    que.add(new Info(sb, L));
                }
                if (!visited[S]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr.command);
                    sb.append("S");
                    visited[S] = true;
                    que.add(new Info(sb, S));
                }
                if (!visited[D]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr.command);
                    sb.append("D");
                    visited[D] = true;
                    que.add(new Info(sb, D));
                }
            }
        }

    }

}

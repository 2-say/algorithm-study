import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baekjoon1541 {

    static Queue<String> que;
    static Queue<Integer> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        que = new ArrayDeque<>();
        tmp = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        que.add("+");
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '-') {
                que.add(sb.toString());
                que.add("-");
                sb = new StringBuilder();
            } else if (exp.charAt(i) == '+') {
                que.add(sb.toString());
                que.add("+");
                sb = new StringBuilder();
            } else {
                sb.append(exp.charAt(i));
            }
        }
        que.add(sb.toString());

        System.out.println(solve());
    }

    static int solve() {
        int ans = 0;
        while (!que.isEmpty()) {
            String a = que.peek(); // 처음 꺼냈는데,
            if (a.equals("-")) { // 만약 음수이면
                String op = que.poll();
                int num = Integer.parseInt(que.poll());
                while (!que.isEmpty() && que.peek().equals("+")) { // 다음 양수 모두 더한다.
                    que.poll();
                    num += Integer.parseInt(que.poll());
                }
                tmp.add(-num);
            } else if (a.equals("+")) {
                que.poll();// op빼기
                tmp.add(Integer.parseInt(que.poll())); // 숫자
            }
        }
        for (int i : tmp) {
            ans += i;
        }

        return ans;

    }
}

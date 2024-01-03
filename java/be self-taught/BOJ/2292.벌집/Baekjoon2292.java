import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int init = 1;
        int ans = 1;
        int tmp = Integer.MAX_VALUE;

        if (n == 1)
            System.out.println(1);
        else {
            for (int i = 1; i < 1_000_000_001; i++) {
                if (tmp <= n && n <= init) {
                    System.out.println(ans);
                    break;
                }
                tmp = init + 1;
                init += 6 * i;
                ans++;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[41];

            dp[0] = 0;
            dp[1] = 1;
            if (n >= 2) {
                for (int j = 2; j <= n; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2];
                }
            }
            if (n == 0)
                System.out.print("1 0");
            else
                System.out.print(dp[n - 1] + " " + dp[n]);
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 2] + dp[i - 1] + dp[i - 3];
        }

        for (int i = 0; i < tc; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }

    }
}

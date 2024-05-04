import java.util.*;
import java.io.*;

class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[10001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i = 3 ; i <= n; i++) {
            dp[i] = ( dp[i-1] + (2 * dp[i-2]) ) % 10007;
        }
        System.out.println(dp[n] % 10007);
    }
}
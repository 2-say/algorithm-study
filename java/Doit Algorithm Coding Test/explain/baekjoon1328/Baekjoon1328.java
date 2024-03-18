
import java.io.*;
import java.util.*;

public class Baekjoon1328 {

    static int div = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int l = arr[1];
        int r = arr[2];
        
        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i][i][1] = dp[i][1][i] = 1;
            for(int j = 1; j < l+1; j++) {
                for(int k=1; k < r+1; k++) {
                    dp[i][j][k] = (dp[i-1][j][k-1] + dp[i-1][j-1][k]   
                                                        + (dp[i-1][j][k] * (i-2)))%div;
                }
            }
        }

        System.out.println(dp[n][l][r]);
    }
}
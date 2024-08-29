import java.io.*;
import java.util.*;

class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] dp = new int[b.length+1][a.length+1];

        for(int i = 1; i <= b.length; i++) {
            for(int j = 1; j <= a.length; j++) {
                if(b[i-1] == a[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[b.length][a.length]);
    }
}
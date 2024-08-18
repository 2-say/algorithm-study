import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int[][] sticker;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            sticker = new int[2][n];

            sticker[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sticker[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            if(n > 1) {
                dp[0][0] = sticker[0][0];
                dp[1][0] = sticker[1][0];
                dp[0][1] = sticker[0][1] + sticker[1][0] ;
                dp[1][1] = sticker[1][1] + sticker[0][0] ;

                for(int j = 2; j < n; j++) {
                    dp[0][j] +=  Math.max(dp[1][j-1], Math.max(dp[0][j-2], dp[1][j-2])) + sticker[0][j];
                    dp[1][j] +=  Math.max(dp[0][j-1], Math.max(dp[0][j-2], dp[1][j-2])) + sticker[1][j];
                }
                
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
            } else {
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
            }
        }
    }
}
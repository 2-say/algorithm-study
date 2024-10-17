import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int answer = 100000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];
        
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solve();
    }

    static void solve() {
        for(int c = 0; c < 3; c++) {
            for(int i = 0; i < 3; i++) {
                if(i == c) dp[0][i] = map[0][i];
                else dp[0][i] = 1001;
            }

            for(int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
            }

            for(int i = 0; i < 3; i++) {
                if(c==i) continue;
                answer = Math.min(answer, dp[N-1][i]);
            }
        }

        System.out.println(answer);
    }
}
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    
    static int[][] arr;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            arr[i] = tmp;
        }
        solve();

        System.out.println(dp[0][0]);
    }


    static void solve() {
        for(int i = 0; i < N; i++) {
            dp[N-1][i]=arr[N-1][i];
        }
        int count = N-1;

        for(int i = N-2; i >= 0; i--) {
            for(int j = 0 ; j < count; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
            count--;
        }        
        



    }
}
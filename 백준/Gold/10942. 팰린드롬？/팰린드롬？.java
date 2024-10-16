import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N][N];

        int M = Integer.parseInt(br.readLine());
        solve();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb);
    }

    static void solve() {
        //Botom up 방식
        for(int i = 0; i < N; i++) { //범위가 1인것은 모두 참
            dp[i][i] = 1;        
        }

        for(int i = 0; i < N-1; i++) { //범위가 2인것은 같을때만 참
            if(arr[i] == arr[i+1]) dp[i][i+1] = 1;
        }

        for(int i = 2; i < N; i++) {
            for(int j = 0; j < N - i; j++) { //개수 정하기
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1) dp[j][j+i] = 1;
            }
        }
    }
}
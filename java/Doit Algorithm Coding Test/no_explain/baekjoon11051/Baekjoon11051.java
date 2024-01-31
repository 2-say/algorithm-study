import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final int MOD = 10_007;

        int[][] d = new int[n+1][n+1];

        for(int i = 0 ; i <= n ; i++){ 
            for(int j = 0 ; j <= n; j++) {
                if(j==0 || i == j) {
                    d[i][j] = 1;
                }
                if(j == 1) {
                    d[i][j] = i;
                }
            }
        }
        for(int i = 1 ; i <= n; i++) {
            for(int j = 1; j <= n; j++) { 
                d[i][j] = (d[i-1][j] + d[i-1][j-1] ) % MOD ;
            }
        }
        System.out.println(d[n][k]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] d = new int[n+1][n+1];
        //d[i][i] = i에서 i개 구하는 것 경우 1;
        //d[i][1] = i에서 1개 구하는 것 경우 i;
        //d[1][0] = 0개 선택하는 경우 1가지 
        
        for(int i = 0 ; i <= n ; i++) {
            for(int j=0; j <= n; j++) {
                if(j == 0 ) {
                    d[i][j] = 1; 
                }
                else if(j == 1) {
                    d[i][j] = i;
                }
                else if(i == j) {
                    d[i][j] = 1;
                }
            }
        }
        //점화식 D[i][j] = D[i-1][j] + D[i-1][j-1]; 
        for(int i = 1 ; i <= n; i++) {
            for(int j = 1; j <=n; j++) {
                d[i][j] = d[i-1][j] + d[i-1][j-1];
            }
        }
        System.out.println(d[n][k]);
    }
}

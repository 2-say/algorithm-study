import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int k = 0; k < tc; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // m개중 n개를 고를 경우
            int[][] d = new int[31][31];
            for (int i = 0; i <= m; i++) {
                d[i][1] = i;
                d[i][0] = 1;
                d[i][i] = 1;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
                }
            }
            System.out.println(d[m][n]);
        }
    }
}

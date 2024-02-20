import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844 {

    static int n;
    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[][] arr = new long[101][101];
        for (int i = 1; i <= 9; i++)
            arr[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    arr[i][0] = arr[i - 1][1] % MOD;
                else if (j == 9)
                    arr[i][9] = arr[i - 1][8] % MOD;
                else
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % MOD;
            }
        }
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += (arr[n][i] % MOD);
        }
        System.out.println(result);
    }

}

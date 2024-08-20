import java.util.*;
import java.io.*;

class Main {

    static long[][] matrix;
    static int N;
    static long B;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(v -> Long.parseLong(v) % MOD).toArray();
        }

        long[][] ret = pow(matrix, B);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(ret[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long[][] pow(long[][] A, long exp) {
        if (exp == 1)
            return matrix;

        long[][] ret = pow(A, exp / 2);
        ret = multiply(ret, ret);

        if (exp % 2 == 1)
            ret = multiply(ret, matrix);

        return ret;
    }

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] ret = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += A[i][k] * B[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
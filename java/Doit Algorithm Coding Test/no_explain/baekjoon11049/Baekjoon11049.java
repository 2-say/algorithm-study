import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon11049 {

    static Matrix[] arr;
    static int[][] memo;

    static class Matrix {
        int r;
        int c;

        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Matrix[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Matrix(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        memo = new int[n + 1][n + 1];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(execute(1, n));

    }

    static public int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (s == e) {
            return 0;
        }
        if (memo[s][e] != -1) {
            return memo[s][e];
        }
        
        if (s + 1 == e) {
            return arr[s].r * arr[s].c * arr[e].c;
        }

        for (int i = s; i < e; i++) {
            result = Math.min(result, execute(s, i) + execute(i + 1, e) + arr[s].r * arr[i].c * arr[e].c);
        }
        return memo[s][e] = result;
    }

}

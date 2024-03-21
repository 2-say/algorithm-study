import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2098 {

    static int[][] w;
    static int n;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 도시의 수
        w = new int[n][n];
        memo = new int[n+1][(1<<(n+1))];

        for (int j = 0; j <= n; j++) {
            Arrays.fill(memo[j], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(solve(0, 0));
    }

    public static int solve(int curr, int visited) {
        if ((1 << (n)) - 1 == visited) {
            if (w[curr][0] > 0) {
                return w[curr][0];
            }
            return 123456789;
        } else if (memo[curr][visited] != Integer.MAX_VALUE) {
            return memo[curr][visited];
        }

        int minCost = 123456789;
        for (int j = 0; j < n; j++) {
            if (w[curr][j] != 0 && ((1 << (j)) & visited) == 0) {
                minCost = Math.min(minCost, solve(j, visited | (1 << j)) + w[curr][j]);
            }
        }
        return memo[curr][visited] = minCost;
    }

}

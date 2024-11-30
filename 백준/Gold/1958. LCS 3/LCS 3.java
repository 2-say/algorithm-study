import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][][] dp;
    static List<String> sList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        dp = new int[a.length()+1][b.length()+1][c.length()+1];

        System.out.println(LCS(a, b, c));
    }

    static int LCS(String a, String b, String c) {
        for(int i = 1; i <= a.length(); i++) {
            char ac = a.charAt(i-1);
            for(int j = 1; j <= b.length(); j++) {
                char bc = b.charAt(j-1);
                for(int k = 1; k <= c.length(); k++) {
                    char cc = c.charAt(k-1);

                    if(ac == bc && bc == cc) { //동일 하다면
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1; //단어 모두 한칸씩 이동
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        return dp[a.length()][b.length()][c.length()];
    }
}
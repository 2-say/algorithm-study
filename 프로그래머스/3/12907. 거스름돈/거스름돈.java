import java.util.*;
class Solution {
    static int[][] dp;
    
    public int solution(int n, int[] money) {
        dp = new int[money.length+1][n+1];
        Arrays.sort(money);
        
        for(int i = 1 ; i <= money.length; i++) {
            for(int j = 0; j <= n; j++) {
                // 0을 만드는 방법은 무조건 1가지
                if(j == 0) 
                    dp[i][j] = 1;
                // money 만큼 되면 dp 계산
                else if(j - money[i-1] >= 0) // money idx를 위해서 -1 계산
                    dp[i][j] = dp[i-1][j] + dp[i][j-money[i-1]] % 1_000_000_007;
                // 그게 아니라면,이전 거스름돈으로 만들 수 있는 경우에 수를 그대로 반영
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[money.length][n];
    }
}

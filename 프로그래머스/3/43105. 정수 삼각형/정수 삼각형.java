import java.io.*;

class Solution {
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length]; //삼각형 최대 개수만큼 추가
        dp[0][0] = triangle[0][0];
        
        //초기값 설정 제일 왼쪽 값이 최대값이라고 했을 때,
        for(int i = 1; i < triangle.length; i++) dp[i][0] = dp[i-1][0] + triangle[i][0];
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 1; j < triangle[i].length; j++) {
                //왼쪽위에서 내려온 값과 위에서 오른쪽위에서 내려온 값 비교
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        int answer = 0;
        //바닥에서 제일 큰 값을 선택
        for(int i : dp[triangle.length-1]) answer = Math.max(i, answer);
        
        return answer;
    }
}
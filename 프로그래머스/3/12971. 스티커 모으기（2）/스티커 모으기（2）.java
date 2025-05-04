class Solution {
    public int solution(int sticker[]) {
        // 첫번째 스티커를 뗄 경우, 아닐 경우로 나눈다.
        
        int len = sticker.length;
        if(len == 1) return sticker[0];
        
        int[] dp = new int[len]; 
        int[] dp1 = new int[len];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        for(int i = 2; i < len-1; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        
        dp1[0] = 0;
        dp1[1] = sticker[1];
        
        for(int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
        }
        
        return Math.max(dp[len-2], dp1[len-1]);
    }
}
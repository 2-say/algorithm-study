class Solution {
    static int[][] map;
     
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        map = new int[n+1][m+1];
        map[1][1] = 1;
        for(int[] pu : puddles) map[pu[1]][pu[0]] = -1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == -1) continue;
                
                if(map[i-1][j] > 0) 
                    map[i][j] = ( map[i][j] + map[i-1][j]) % mod;
                
                if(map[i][j-1] > 0) 
                    map[i][j] = ( map[i][j] + map[i][j-1]) % mod;
            }
        }
        
        return map[n][m];
    }
}
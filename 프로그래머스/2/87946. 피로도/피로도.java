import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int len;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        len = dungeons.length;
        visited = new boolean[len];
        
        dfs(0, k, dungeons);
        return answer;
    }
    
    
    
    static void dfs(int idx, int k, int[][] dungeons) {
        if(idx == len) {
            int count = 0;
            
            for(boolean b : visited) if(b) count++;
            if(answer < count) answer = count;
            return;
        }
        
        
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] > k) {
                    dfs(idx + 1, k, dungeons);
                } else {
                    visited[i] = true;
                    dfs(idx + 1, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}
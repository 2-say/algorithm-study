import java.util.*;

class Solution {
    int[][] C;
    int N;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        C = computers;
        N = n;
        
        int answer = 0;
        visited = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int s) {
        Stack<Integer> stac = new Stack();
        visited[s] = true;
        stac.push(s);
        
        while(!stac.isEmpty()) {
            int cur = stac.pop();
            
            for(int i = 0; i < N; i++) {
                if(i == cur || C[cur][i] == 0) continue;
                
                if(!visited[i]) {
                    visited[i] = true;
                    stac.push(i);
                }
            }
        }
    }
}
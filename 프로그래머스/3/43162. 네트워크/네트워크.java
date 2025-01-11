import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int s, int[][] computers) {
        Stack<Integer> stac = new Stack<>();
        stac.add(s);
        visited[s] = true;
        
        while(!stac.isEmpty()) {
            int cur = stac.pop();
            
            for(int i = 0; i < computers.length; i++) {
                if(i != cur && computers[cur][i] == 1) {
                    if(!visited[i]) {
                        stac.add(i);
                        visited[i] = true;
                    }   
                }
            }
        }
    }
    
}
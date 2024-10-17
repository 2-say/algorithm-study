import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] nList;
    static int N;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        N = n;
        
        nList = new List[n];
        for(int i =0; i < n; i++) nList[i] = new ArrayList<>();
        
        for(int[] wire : wires) {
            nList[wire[0]-1].add(wire[1]-1);
            nList[wire[1]-1].add(wire[0]-1);
        }
        
        visited = new boolean[n];
        visited[0] = true;
        dfs(0);
        return answer;
    }
    
    static int dfs(int cur) {
        int sum = 0;
        
        for(int n : nList[cur]) {
            if(!visited[n]) {
                visited[n] = true;
                int cnt = dfs(n);
                answer = Math.min(answer, Math.abs(N - (cnt*2))); //(N - cnt) - cnt
                sum += cnt; //방문했던 노드 수 만큼 증가
            }
       }
        
        return sum + 1 ;
    }
}
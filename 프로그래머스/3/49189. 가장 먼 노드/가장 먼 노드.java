import java.util.*;

class Solution {
    static List<Integer>[] nList;
    public int solution(int n, int[][] edge) {
        nList = new List[n+1];
        for(int i = 0; i < n+1; i++) nList[i] = new ArrayList<>();
        
        for(int[] ed : edge) {
            int s = ed[0];
            int e = ed[1];
            nList[s].add(e);
            nList[e].add(s);
        }
        
        return bfs(edge, n);
    }
    
    public int bfs(int[][] edge, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        q.add(new int[] {1, 0});
        visited[1] = true;
        
        int max = 0;
        Map<Integer, Integer> aMap = new HashMap<>();
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            aMap.put(cur[0], cur[1]);
            max = Math.max(max , cur[1]);
            List<Integer> nxtL = nList[cur[0]];
            
            for(Integer next : nxtL) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] {next, cur[1] + 1});
                }
            }
        }
        
        int answer = 0;
        for(Map.Entry<Integer, Integer> e : aMap.entrySet()) {
            if(e.getValue() == max) answer++;
        }
        
        return answer;
    }
}
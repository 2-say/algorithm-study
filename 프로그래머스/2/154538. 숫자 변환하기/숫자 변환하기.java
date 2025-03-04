import java.util.*;

class Solution {
    static int answer = 99_999_999;
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        visited = new boolean[1_000_001];
        dfs(x, y, n, 0);
        return (answer == 99_999_999) ? -1 : answer;
    }
    
    public void dfs(int x, int y, int n, int count) {
        Queue<int[]> pq = new ArrayDeque<>();
        pq.add(new int[] {x, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = true;
            
            if(cur[0] == y) {
                answer = Math.min(answer, cur[1]);
                return;
            }
            
            if(cur[0] * 2 <= y && !visited[cur[0] * 2]) {
                pq.add(new int[] {cur[0] * 2, cur[1] + 1});
            } if(cur[0] * 3 <= y && !visited[cur[0] * 3]) {
                pq.add(new int[] {cur[0] * 3, cur[1] + 1});
            } if(cur[0] + n <= y && !visited[cur[0] + n]) {
                pq.add(new int[] {cur[0] + n, cur[1] + 1});
            }
        }
    }
}
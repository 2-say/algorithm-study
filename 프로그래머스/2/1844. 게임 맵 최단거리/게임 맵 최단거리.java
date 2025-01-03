import java.util.*;

class Solution {
    static int[] dy = {0,0,1,-1}, dx ={1,-1,0,0};
    static boolean[][] visited;
    
    public int bfs(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[maps.length][maps[0].length];
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == maps.length-1 && cur[1] == maps[0].length-1) {
                answer = Math.min(answer, cur[2]);
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(!isValid(ny, nx, maps) || visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx, cur[2] + 1});
            }
        }
        
        return (answer == Integer.MAX_VALUE) ? -1 : answer+1;
    }
    
    public boolean isValid(int y, int x, int[][] maps) {
        return x >= 0 && y>= 0 && y < maps.length && x < maps[0].length && maps[y][x] != 0;
    }
     
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}
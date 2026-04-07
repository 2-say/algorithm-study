import java.util.*;

class Solution {
    int[][] MAP;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        MAP = maps;
        visited = new boolean[maps.length][maps[0].length];
        return bfs();
    }
    
    public int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            int dis = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i]; 
                int ny = curY + dy[i]; 
                
                if(ny == MAP.length - 1 && nx == MAP[0].length - 1) {
                    return dis + 1;
                }
                
                if(isValid(nx, ny) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx, dis + 1});
                }
            }
        }
        
        return -1;
    }
    
    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < MAP[0].length && y < MAP.length && MAP[y][x] != 0;
    }
}
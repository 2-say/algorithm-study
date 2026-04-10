import java.util.*;

class Solution {
    final int MAX_SIZE = 140;
    int[] dy = {0, 0, 1, -1, 1, -1, 1, -1}, dx = {1, -1, 0, 0, 1, -1, -1, 1};
    Queue<Integer> pq = new PriorityQueue<>();
    int[][] M = new int[MAX_SIZE][MAX_SIZE];
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        drawMap(rectangle);
        greedy(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        
        return answer;
    }
    
    public void drawMap(int[][] rectangle) {
        int color = 0;
        for(int[] rec : rectangle) {
            color++;
            int x1 = rec[0] * 2, y1 = rec[1] * 2;
            int x2 = rec[2] * 2, y2 = rec[3] * 2;
            
            for(int y = y1; y <= y2; y++) {
                for(int x = x1; x <= x2; x++) {
                    M[y][x] = color;
                }
            }
        }
    }
    
    public void greedy(int sy, int sx, int ey, int ex) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
        
        visited[sy][sx] = true;
        q.add(new int[] {sy, sx , 0});
        
        while(!q.isEmpty()) {
            int[] c = q.poll();
            int curY = c[0];
            int curX = c[1];
            int distance = c[2];
            
            if(curY == ey && curX == ex) {
                answer = Math.min(answer, distance / 2);
                return;
            }
            
            Queue<Integer> ableDir = new ArrayDeque<>();
            for(int i = 0; i < 4; i++) {
                int nY = curY + dy[i];
                int nX = curX + dx[i];

                if(!isValid(nY, nX)) continue;
                if(visited[nY][nX]) continue;
                if(M[nY][nX] == 0) continue;
                
                int neighborZeroC = 0;
                for(int j = 0; j < 8; j++) {
                    int neY = nY + dy[j];
                    int neX = nX + dx[j];
                    
                    if(!isValid(neY, neX)) continue;
                    if(M[neY][neX] == 0) neighborZeroC++;
                }
                
                if(neighborZeroC >= 1) {
                    visited[nY][nX] = true;
                    q.add(new int[] {nY, nX, distance + 1});
                }
            }
        }
        
    }
    
    public boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < MAX_SIZE && x < MAX_SIZE;
    }
}
import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
    static int M, N;
    
    public int solution(String[] maps) {
        int answer = 0;
        M = maps.length; 
        N = maps[0].length();
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        
        //레버 위치 찾기 && 골 지점 찾기
        for(int i = 0; i < M; i++) {
            String[] split = maps[i].split("");
            for(int j = 0; j < N; j++) {
                if(split[j].equals("L")) {
                    lever[0] = i;
                    lever[1] = j;
                }
                
                if(split[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                
                if(split[j].equals("E")) {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }    
        
        
        int tmp = bfs(start, lever, maps);
        if(tmp == -1) return -1;
        else answer += tmp; 
        
        
        tmp = bfs(lever, exit, maps);
        if(tmp == -1) return -1;
        else answer += tmp; 
        
        return answer;
    }
    
    
    public int bfs(int[] s, int[] goal, String[] maps) {
        visited = new boolean[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {s[0], s[1], 0});
        visited[s[0]][s[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == goal[0] && cur[1] == goal[1]) {
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(isValid(ny, nx, maps) && !visited[ny][nx]) {
                    q.add(new int[]{ny, nx, cur[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return -1; 
    }
    
    public boolean isValid(int y, int x, String[] maps) {
        if(y >= 0 && x >= 0 && y < M && x < N) {
            String[] split = maps[y].split("");
            return !split[x].equals("X");
        } else {
            return false;
        }
    } 
}
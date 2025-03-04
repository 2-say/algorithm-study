import java.util.*;

class Solution {
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int sY, sX;
    static int eY, eX;
    static int answer = 99_999_999;
    
    public int solution(String[] board) {
        N = board.length;
        String[] sp = board[0].split("");
        M = sp.length;
        map = new int[N][M];
        visited = new boolean[N][M][4];
        
        for(int i = 0; i < N; i++) {
            String[] s = board[i].split("");
            for(int j = 0; j < s.length; j++) {
                if(s[j].equals("D")) map[i][j] = 1;
                else if(s[j].equals("G")) {
                    eY = i;
                    eX = j;
                } else if(s[j].equals("R")) {
                    sY = i;
                    sX = j;
                }
            }
        }
        
        dfs(board);
        if(answer == 99_999_999) return -1;
        return answer;
    }
    
    public void dfs(String[] board) {
        Queue<int[]> q = new ArrayDeque<>();
        putNextMove(q, sY, sX, 1);
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == eY && cur[1] == eX) {
                answer = Math.min(answer, cur[2]);
                return;
            }
            
            putNextMove(q, cur[0], cur[1], cur[2] + 1);
        }
    }
    
    public boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M && map[y][x] != 1;
    }
    
    public void putNextMove(Queue q, int y, int x, int mc) {
        for(int i = 0; i < 4; i++) {
            int nY = y;
            int nX = x;
            while(isValid(nY, nX)) {
                nY += dy[i];
                nX += dx[i];
            }
            nY -= dy[i];
            nX -= dx[i];
            
            if(visited[y][x][i]) continue;
            visited[y][x][i] = true;
            q.add(new int[] {nY, nX, mc});
        }
    }
}
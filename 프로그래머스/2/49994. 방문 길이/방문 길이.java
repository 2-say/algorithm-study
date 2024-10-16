class Solution {
    static final int MAX_N = 10;
    static boolean[][][] visited = new boolean[MAX_N+1][MAX_N+1][4]; //방향까지 고려
    static int U = 0, L = 1, D = 2,  R = 3;
    
    static class P {
        int y, x;
        P(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    
    public int solution(String dirs) {
        int answer = 0;
        char[] carr = dirs.toCharArray();
        P cur = new P(5, 5);
        
        for(int i = 0; i < dirs.length(); i++) {
            int ny = cur.y;
            int nx = cur.x;
            int d = -1;
            
            if(carr[i] == 'U') { 
                ny--; 
                d = U;
            } else if(carr[i] == 'L') {
                nx--;  
                d = L;
            } else if(carr[i] == 'R') {
                nx++;
                d = R;
            } else if(carr[i] == 'D') {
                ny++;
                d = D;
            }
            
            if(!inRange(ny, nx)) continue;
            
            if(!visited[ny][nx][d]) {
                answer++;
                visited[ny][nx][d] = true;
                visited[cur.y][cur.x][(d+2)%4] = true;
            }
            cur.y = ny;
            cur.x = nx;
        }
        
        return answer;
    }
    
    static boolean inRange(int y, int x) {
        return y >= 0 && x >= 0 && y <= MAX_N && x <= MAX_N;
    }
    
    
}
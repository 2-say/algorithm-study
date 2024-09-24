import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static boolean[][] visited;
    static P shark;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int N;

    static class P implements Comparable<P> {
        int x;
        int y;
        int eatC;
        int level;
        int point;

        P(int x, int y, int level, int point, int eatC) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.point = point;
            this.eatC = eatC;
        }

        void setLevelUp() {
            this.level += 1;
            this.eatC = 0;
        }

        void resetPoint() {
            this.point = 0;
        }

        @Override
        public int compareTo(P o) {
            if(x == o.x)
                return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                if(map[i][j] == 9) { 
                    shark = new P(i,j,2,0,0);
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        P next = shark;
        PriorityQueue<P> que = bfs(next);

        while(!que.isEmpty()) {
            next = que.poll();
            map[next.x][next.y] = 0;
            answer += next.point;
            if(next.eatC >= next.level) next.setLevelUp();
            next.resetPoint();
            que = bfs(next); 
        }

        System.out.println(answer);
    }   

    static PriorityQueue<P> bfs(P start) {
        visited = new boolean[N][N];
        Queue<P> que = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        que.add(start);

        PriorityQueue<P> pQue = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        
        while(!que.isEmpty()) {
            P cur = que.poll();

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + cur.x;
                int nY = dy[i] + cur.y;

                if(isValid(nX, nY, cur.level)) {
                    visited[nX][nY] = true;

                    if(map[nX][nY] != 0 && map[nX][nY] < cur.level) {
                        if(min >= cur.point) {
                            min = cur.point;
                            pQue.add(new P(nX, nY, cur.level, cur.point+1, cur.eatC+1));
                        }
                    } else {
                        que.add(new P(nX, nY, cur.level, cur.point+1, cur.eatC));
                    }
                }
            }
        }

        return pQue;
    }

    static boolean isValid(int x, int y, int level) {
        return x >= 0 && y >= 0 && x < N && y < N && map[x][y] <= level && !visited[x][y];
    }
}
import java.io.*;
import java.util.*;


class Main { 
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0,1,0,-1}, dx = {1,0,-1,0};
    static final int MAX_V =  999_999;

    static class P implements Comparable<P>{
        int y,x,cost;
        P(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
        @Override
        public int compareTo(P o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs());
    }
    

    static int bfs() {
        Queue<P> q = new PriorityQueue<>();
        q.add(new P(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            P cur = q.poll();
            if(cur.y == N-1 && cur.x == N-1) return cur.cost;
            
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(!inRange(ny, nx) || visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                if(map[ny][nx] == 0) q.add(new P(ny, nx, cur.cost + 1));
                else q.add(new P(ny, nx, cur.cost));
            }
        }

        return -1;
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

}
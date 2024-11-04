import java.io.*;
import java.util.*;


class Main {

    static int[][] map;
    static int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};
    static int N;
    static int[][] dist;

    static class P {
        int y, x;

        P(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        StringBuilder sb = new StringBuilder();

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++)
                Arrays.fill(dist[i], 999_999);

            for(int i = 0; i < N; i++) 
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dfs();
            
            sb.append("Problem ").append(count).append(": ").append(dist[N-1][N-1]).append("\n");
            count++;
        }
        System.out.println(sb);
    }

    static void dfs() {
        Queue<P> stac = new ArrayDeque<>();
        stac.add(new P(0, 0));
        dist[0][0] = map[0][0];

        while(!stac.isEmpty()) {
            P cur = stac.poll();

            for(int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if(!inRange(ny, nx)) continue;

                if(dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
                    dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
                    stac.add(new P(ny, nx));
                }
            }
        }
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
    
}
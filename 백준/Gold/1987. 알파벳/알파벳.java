import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static int R;
    static int C;
    static int max;
    
    static class P {
        int r;
        int c;
        int count;
        boolean[] visited;

        P(int r, int c, int count, boolean[] visited) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.visited = visited;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        max = Integer.MIN_VALUE;
        
        for(int r = 0 ; r < R; r++) {
            String input = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
            }
        }
        
        dfs(0, 0, new boolean[26]);
        System.out.println(max);
    }

    static void dfs(int sR, int sC, boolean[] vi) {
        Stack<P> stac = new Stack<>();
        vi[map[sR][sC] - 65] = true;
        stac.add(new P(sR, sC, 1, vi));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1 ,0, 0};
        
        while(!stac.isEmpty()) {
            P cur = stac.pop();
            if(max < cur.count) max = cur.count;

            for(int i = 0 ; i < 4; i++) {
                int nX = cur.r + dx[i];
                int nY = cur.c + dy[i];

                if(isValid(nX, nY, cur.visited)) {
                    boolean[] copy = cur.visited.clone();
                    copy[map[nX][nY]-65] = true;
                    stac.add(new P(nX, nY, cur.count + 1, copy));
                }
            }
        }
    }

    static boolean isValid(int nX, int nY, boolean[] visited) {
        return nX >= 0 && nY >= 0 && nX < R && nY < C && !visited[map[nX][nY]-65];
    }
}
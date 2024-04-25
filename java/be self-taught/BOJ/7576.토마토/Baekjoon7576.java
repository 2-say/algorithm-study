import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {

    static class P {
        int x;
        int y;
        int count;

        public P(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];

        List<P> ripe = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    ripe.add(new P(i, j, 0));
            }
        }

        int tmp = 0;
        tmp = bfs(ripe);

        System.out.println(checkAnswer(tmp));
    }

    private static int bfs(List<P> ripe) {
        Queue<P> que = new ArrayDeque<>();

        for (P p : ripe) {
            que.add(p);
            visited[p.x][p.y] = true;
        }

        int day = 0;
        while (!que.isEmpty()) {
            P cur = que.poll();
            day = cur.count;

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dx[i];
                int nY = cur.y + dy[i];

                if (isValid(nX, nY)) {
                    visited[nX][nY] = true;
                    que.add(new P(nX, nY, cur.count + 1));
                }
            }
        }

        return day;
    }

    private static int checkAnswer(int day) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return day;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] != -1 && !visited[x][y];
    }
}

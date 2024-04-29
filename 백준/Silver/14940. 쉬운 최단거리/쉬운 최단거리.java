import java.util.*;
import java.io.*;

class Main {

    static int[][] map;
    static int[][] mapC;
    static boolean[][] visited;

    static class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        mapC = new int[n][m];
        visited = new boolean[n][m];

        Point startP = null;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                mapC[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    startP = new Point(i, j, 0);
                }
            }
        }
        bfs(startP);
        printMap();
    }

    public static void bfs(Point start) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        Queue<Point> que = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        que.add(start);
        mapC[start.x][start.y] = start.distance;

        while (!que.isEmpty()) {
            Point curr = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = curr.x + dx[i];
                int nY = curr.y + dy[i];

                if (isValid(nX, nY)) {
                    mapC[nX][nY] = curr.distance + 1;
                    visited[nX][nY] = true;
                    que.add(new Point(nX, nY, curr.distance + 1));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] != 0 && !visited[x][y];
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapC.length; i++) {
            for (int j = 0; j < mapC[0].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(mapC[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
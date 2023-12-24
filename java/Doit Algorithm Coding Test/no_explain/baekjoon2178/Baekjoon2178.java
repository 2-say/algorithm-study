import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class Baekjoon2178 {
    static boolean visited[][];
    static boolean map[][];
    static int n, m;
    static ArrayList<Integer> answer;
    
    static class Point {
        int x;
        int y;
        int dis;

        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new boolean[n][m];
        visited = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            String[] mapStr = br.readLine().split("");
            for (int c = 0; c < m; c++) {
                if(Integer.parseInt(mapStr[c]) == 1) map[r][c] = true;
            }
        }
        answer = new ArrayList<>();
        bfs(new Point(0, 0, 1));
        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.get(0));
    }

    static void bfs(Point start) {
        int[] nx = { 1, -1, 0, 0 };
        int[] ny = { 0, 0, 1, -1 };
        Queue<Point> que = new ArrayDeque<>();
        que.add(start);
        visited[start.x][start.y] = true;

        while (!que.isEmpty()) {
            Point curr = que.poll();
            if (curr.x == n - 1 && curr.y == m - 1) {
                answer.add(curr.dis);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextx = curr.x + nx[i];
                int nexty = curr.y + ny[i];
                if (isValid(nextx, nexty)) {
                    que.add(new Point(nextx, nexty, curr.dis + 1));
                    visited[nextx][nexty] =true;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && map[x][y]) {
            return true;
        }
        return false;

    }
}

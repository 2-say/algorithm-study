import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14500 {
    static int[][] map;
    static int n;
    static int m;
    static int max;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp;
                if ((tmp = dfs(0, 0, i, j)) > answer) {
                    answer = tmp;
                }
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int score, int currInd, int r, int c) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        
        if (currInd == 2) {
            for (int i = 0; i < 4; i++) {
                int nextR = r + dx[i];
                int nextC = c + dy[i];
                if (isValid(nextR, nextC)) {
                    visited[nextR][nextC] = true;
                    dfs(map[nextR][nextC] + score, currInd + 1, r, c);
                    visited[nextR][nextC] = false;
                }
            }
        }
        if (currInd == 4) {
            max = Math.max(score, max);
        } else {
            for (int i = 0; i < 4; i++) {
                int nextR = r + dx[i];
                int nextC = c + dy[i];
                if (isValid(nextR, nextC)) {
                    visited[nextR][nextC] = true;
                    dfs(map[nextR][nextC] + score, currInd + 1, nextR, nextC);
                    visited[nextR][nextC] = false;
                }
            }
        }

        return max;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length && !visited[r][c];
    }
}

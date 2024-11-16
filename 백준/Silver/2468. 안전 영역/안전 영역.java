import java.io.*;
import java.util.*;

class Main {

  static int[][] map;
  static boolean[][] visited;
  static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };
  static int N;
  static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    for (int i = 0; i < N; i++)
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
    ans = 0;
    for (int i = 0; i <= 100; i++) {
      solve(i);
    }
    System.out.println(ans);
  }

  static void solve(int h) {
    boolean[][] isDie = new boolean[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) { // 침수 확인
      for (int j = 0; j < N; j++) {
        if (map[i][j] <= h)
          isDie[i][j] = true;
      }
    }

    int color = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && !isDie[i][j]) {
          dfs(i, j, isDie);
          color++;
        }
      }
    }

    ans = Math.max(color, ans);
  }

  static void dfs(int sy, int sx, boolean[][] isDie) {
    Stack<int[]> stac = new Stack<>();
    stac.add(new int[] { sy, sx });
    visited[sy][sx] = true;

    while (!stac.isEmpty()) {
      int[] cur = stac.pop();

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if (inRange(ny, nx) && !visited[ny][nx] && !isDie[ny][nx]) {
          visited[ny][nx] = true;
          stac.add(new int[] { ny, nx });
        }
      }
    }
  }

  static boolean inRange(int y, int x) {
    return y >= 0 && x >= 0 && y < N && x < N;
  }
}
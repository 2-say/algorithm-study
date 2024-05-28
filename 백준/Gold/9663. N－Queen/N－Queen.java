import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        System.out.println(solve(new boolean[n][n], new int[]{0}, 0));
    }

    public static int solve(boolean[][] map, int[] count, int depth) {
        if (depth == n) {
            ++count[0];
            return -1;
        }

        for (int j = 0; j < n; j++) {
            if (!exitstQueen(map, depth, j)) {
                map[depth][j] = true;
                solve(map, count, depth + 1);
                map[depth][j] = false;
            }
        }
        return count[0];
    }

    public static boolean exitstQueen(boolean[][] map, int x, int y) {
        // 내가 놓을려는 x , y 자리에 퀸이 있는지 확인
        // + 방향
        for (int i = 0; i < n; i++) {
            if (map[x][i])
                return true;
            if (map[i][y])
                return true;
        }
        // 대각선
        int xC = x;
        int yC = y;
        while (xC >= 0 && yC >= 0) {
            if (map[xC][yC]) {
                return true;
            }
            xC--;
            yC--;
        }

        // 대각선
        xC = x;
        yC = y;
        while (xC >= 0 && yC < n) {
            if (map[xC][yC]) {
                return true;
            }
            xC--;
            yC++;
        }
        // 대각선
        xC = x;
        yC = y;
        while (xC < n && yC >= 0) {
            if (map[xC][yC]) {
                return true;
            }
            xC++;
            yC--;
        }
        // 대각선
        xC = x;
        yC = y;
        while (xC < n && yC < n) {
            if (map[xC][yC]) {
                return true;
            }
            xC++;
            yC++;
        }

        return false;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n * 2];

        recurtion(0, n - 1, n);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                if (map[i][j] == '\u0000') {
                    sb.append(" ");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // 한변의 길이
    static void recurtion(int x, int y, int val) {
        // 종료 조건
        if (val <= 3) {
            map[x][y] = '*';
            map[x + 1][y + 1] = map[x + 1][y - 1] = '*';
            map[x + 2][y] = map[x + 2][y - 1] = map[x + 2][y - 2] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
        } else {
            val /= 2;
            recurtion(x, y, val);
            recurtion(x + val, y + val, val);
            recurtion(x + val, y - val, val);
        }
    }
}
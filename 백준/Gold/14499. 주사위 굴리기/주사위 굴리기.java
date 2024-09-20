import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static int[] commands;
    static int[] dice;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new int[6];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        }

        commands = Arrays.stream(br.readLine().split(" "))
                         .mapToInt(Integer::parseInt)
                         .toArray();

        solve(x, y);
    }

    static void solve(int sx, int sy) {
        int curX = sx;
        int curY = sy;

        for (int c : commands) {
            int nX = dx[c] + curX;
            int nY = dy[c] + curY;

            if (nX < 0 || nX >= map.length || nY < 0 || nY >= map[0].length) {
                continue;
            }

            if (c == 1) {
                int[] tmp = new int[6];
                tmp[4] = dice[4];
                tmp[5] = dice[5];
                tmp[0] = dice[3];
                tmp[3] = dice[1];
                tmp[1] = dice[2];
                tmp[2] = dice[0];
                dice = tmp.clone();
            } else if (c == 2) {
                int[] tmp = new int[6];
                tmp[4] = dice[4];
                tmp[5] = dice[5];
                tmp[3] = dice[0]; // 바닥이 오른쪽
                tmp[0] = dice[2]; // 왼쪽이 바닥
                tmp[2] = dice[1]; // 윗면이 왼쪽
                tmp[1] = dice[3]; // 오른쪽이 윗면
                dice = tmp.clone();
            } else if (c == 3) {
                int[] tmp = new int[6];
                tmp[2] = dice[2];
                tmp[3] = dice[3];
                tmp[5] = dice[0]; // 바닥 -> 뒷방향
                tmp[0] = dice[4]; // 앞방향이 바닥
                tmp[4] = dice[1]; // 윗면이 앞 방향
                tmp[1] = dice[5];  // 뒷방향이 -> 윗면
                dice = tmp.clone();
            } else if (c == 4) {
                int[] tmp = new int[6];
                tmp[2] = dice[2];
                tmp[3] = dice[3];
                tmp[0] = dice[5]; // 뒷방향 -> 바닥
                tmp[4] = dice[0]; // 바닥이 앞방
                tmp[5] = dice[1]; // 윗면이 뒷방향
                tmp[1] = dice[4];  // 앞방향이 윗면
                dice = tmp.clone();
            }

            downCheck(nX, nY);

            curX = nX;
            curY = nY;

            System.out.println(dice[1]);
        }
    }

    static void downCheck(int x, int y) {
        if (map[x][y] == 0) {
            map[x][y] = dice[0];
        } else {
            dice[0] = map[x][y];
            map[x][y] = 0;
        }
    }
}

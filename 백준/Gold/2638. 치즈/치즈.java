import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] map;
    static int N;
    static int M;
    static int cheeseNum;
    static int time;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static boolean[][] visted;

    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visted = new boolean[N][M];
        time = 0;

        Queue<P> cheeseP = new ArrayDeque();
        Queue<P> removeCheese = new ArrayDeque();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseP.add(new P(i, j));
                }
            }
        }

        checkOutsideCheese(0, 0); // 외부 치즈 표시 map == 3번은 외부

        while (!cheeseP.isEmpty()) {
            for (P c : cheeseP) {
                // 치즈에 4방향 확인
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nX = dx[k] + c.x;
                    int nY = dy[k] + c.y;


                    if (nX >= 0 && nY >= 0 && nX < N && nY < M && map[nX][nY] == 3) {
                        count++;
                    }
                }
                if (count >= 2) {
                    removeCheese.add(c);
                }
            }
            //외부 치즈 삭제
            while (!removeCheese.isEmpty()) {
                P cur = removeCheese.poll();
                map[cur.x][cur.y] = 3;
                cheeseP.remove(cur);
                checkOutsideCheese(cur.x, cur.y);
            }
            time++;
        }

        System.out.println(time);
    }

    static void checkOutsideCheese(int x, int y) {
        Stack<P> stac = new Stack<>();
        stac.add(new P(x, y));
        visted[x][y] = true;

        while (!stac.isEmpty()) {
            P cur = stac.pop();

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + cur.x;
                int nY = dy[i] + cur.y;

                if (nX >= 0 && nY >= 0 && nX < N && nY < M && map[nX][nY] == 0 && !visted[nX][nY]) {
                    visted[nX][nY] = true;
                    map[nX][nY] = 3; // 외부 치즈 표시;
                    stac.add(new P(nX, nY));
                }
            }
        }
    }
}
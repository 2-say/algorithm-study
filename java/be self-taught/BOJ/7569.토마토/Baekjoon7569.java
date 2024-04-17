import java.io.*;
import java.util.*;

public class Baekjoon7569 {

    static int[][][] invent;

    static class Tomato {
        int n;
        int m;
        int h;
        int counnt;

        public Tomato(int n, int m, int h, int count) {
            this.n = n;
            this.m = m;
            this.h = h;
            this.counnt = count;
        }
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 열
        int n = Integer.parseInt(st.nextToken()); // 행
        int h = Integer.parseInt(st.nextToken()); // 높이

        List<Tomato> tomatos = new ArrayList<>();

        invent = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {

                    invent[i][j][k] = Integer.parseInt(input[k]);
                    if (invent[i][j][k] == 1)
                        tomatos.add(new Tomato(j, k, i, 0));
                }
            }
        }

        int result = solve(tomatos);
        boolean isImpossible = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (invent[i][j][k] == 0) {
                        isImpossible = true;
                        break;
                    }
                }
            }
        }
        if (isImpossible)
            System.out.println("-1");
        else {
            System.out.println(result);
        }
    }

    public static int solve(List<Tomato> tomatos) {
        Queue<Tomato> que = new ArrayDeque();
        int result = 0;

        int[] dx = { 1, -1, 0, 0, 0, 0 };
        int[] dy = { 0, 0, 1, -1, 0, 0 };
        int[] dz = { 0, 0, 0, 0, 1, -1 };

        for (Tomato tomato : tomatos) {
            que.add(tomato);
        }

        while (!que.isEmpty()) {
            Tomato ripe = que.poll();
            result = ripe.counnt;

            for (int i = 0; i < 6; i++) {
                int nextN = ripe.n + dx[i];
                int nextM = ripe.m + dy[i];
                int nextH = ripe.h + dz[i];

                if (isValid(nextN, nextM, nextH)) {
                    invent[nextH][nextN][nextM] = 1;
                    que.add(new Tomato(nextN, nextM, nextH, ripe.counnt + 1));
                }
            }
        }

        return result;
    }

    public static boolean isValid(int n, int m, int h) {
        return n >= 0 && m >= 0 && h >= 0 && m < invent[0][0].length && n < invent[0].length && h < invent.length
                && invent[h][n][m] != -1 && invent[h][n][m] == 0;
    }

}

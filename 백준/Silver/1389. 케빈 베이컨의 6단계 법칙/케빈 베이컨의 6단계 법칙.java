import java.io.*;
import java.util.*;


class Main {

    static int[][] map; 
    static int N, M;
    static final int MAX_VALUE = 9_999_999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(map[i], MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1; 
            map[b][a] = 1;
        }
        
        floydWall();

        System.out.println(resultMinBacon());
    }


    static void floydWall() {
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);                
                }
            }
        }
    }

    static int resultMinBacon() {
        int minS = MAX_VALUE;
        int answer = -1;
        for(int i = 0; i < N; i++) {
            int score = 0;
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    score += map[i][j];
                }
            }

            if(minS > score) {
                minS = score;
                answer = i;
            }
        }

        return answer + 1;
    }
}
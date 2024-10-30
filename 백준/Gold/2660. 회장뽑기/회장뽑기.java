import java.io.*;
import java.util.*;

class Main {

    static int[][] map; 
    static int N;
    static int minS;
    static final int MAX_VALUE = 9_999_999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(map[i], MAX_VALUE);

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;

            map[a-1][b-1] = 1; 
            map[b-1][a-1] = 1;
        }
        
        floydWall();

        List<Integer> result = findResult();
        StringBuilder sb = new StringBuilder();

        sb.append(minS).append(" ").append(result.size()).append("\n");
        Collections.sort(result);
        for(int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
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

    static List<Integer> findResult() {
        minS = MAX_VALUE;

        for(int i = 0; i < N; i++) {
            int score  = 0;
            for(int j = 0; j < N; j++) {
                if(i != j)
                    score = Math.max(map[i][j], score);
            }

            minS = Math.min(minS, score);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int score  = 0;
            for(int j = 0; j < N; j++) {
                if(i != j)
                    score = Math.max(map[i][j], score);
            }

            if(minS == score) {
                result.add(i+1);
            }
        }

        return result;
    }
}
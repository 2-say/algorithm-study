import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[][] live = new int[15][15];
        //0층 초기화
        for(int i = 0 ; i < 15 ; i++)
            live[0][i] = i;
        
        for(int i = 1 ; i < 15; i++) {
            for(int j = 1 ; j < 15; j++) {
                for(int k = 1 ; k <= j; k++) {
                    live[i][j] += live[i-1][k];
                }
            }
        }
        
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(live[k][n]);
        }

    }
}

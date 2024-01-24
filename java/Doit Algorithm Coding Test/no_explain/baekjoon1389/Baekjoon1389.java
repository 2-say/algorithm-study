import java.io.*;
import java.util.*;

public class Baekjoon1389 {

    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n][n];

        for(int i = 0 ; i< n; i++){
            for(int j=0; j<n; j++){
                if(i == j) list[i][j] =0;
                list[i][j] = 999999;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            list[s][e] = 1;
            list[e][s] = 1;
        }
        int[] result = new int[n];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j] );
                }
            }
        }
        
        for(int i = 0; i < n ;i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                result[i] += list[i][j];
            }
        }
        int[] tmp = result.clone();
        Arrays.sort(tmp);
        int min = tmp[0];

        for(int i = 0 ; i < n ;i++){
            if(min == result[i]){
                System.out.println(i+1);
                break;
            }
        }
    }
}

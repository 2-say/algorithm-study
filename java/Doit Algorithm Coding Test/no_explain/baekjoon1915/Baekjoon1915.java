import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1915 {
    static long[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new long[1001][1001];

        for (int i = 0; i < n; i++) {
            String[] arrInput = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Long.parseLong(arrInput[j]);
            }
        }
        
        long max = 0 ;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && i > 0  && j > 0) {
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]))+ arr[i][j];
                }
                if(max < arr[i][j])
                    max = arr[i][j];
            }
        }
        System.out.println(max*max);
    }
}

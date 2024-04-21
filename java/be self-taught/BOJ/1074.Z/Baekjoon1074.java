import java.io.*;
import java.util.*;

public class Baekjoon1074 {

    static int[][] result;
    static int value;
    static int findR;
    static int findC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findR= arr[1];
        findC= arr[2];
        value = 0;
        int size = (int) Math.pow(2, arr[0]);
        result = new int[(size * size) + 1][(size * size) + 1];
        solve();

    }

    static void solve() {
        int r=0;
        int c=0;
        int size=1;
        while(true) {
            if(result[findR][findC] != 0) {
                System.out.println(result[findR][findC]);
                break;
            }

            for(int i = 0 ; i < 4; i++) {
                result[r][c] = value++;
                result[r][c+size]= value++;
                result[r+size][c]= value++;
                result[r+size][c+size] = value++;
            }
            size *= 2;
        }

    }
}

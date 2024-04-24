import java.io.*;

public class Baekjoon9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        long[] result = new long[101];
        result[1] = 1;
        result[2] = 1;
        result[3] = 1;
        result[4] = 2;
        result[5] = 2;
        for (int j = 6; j <= 100; j++) {
            result[j] = result[j - 5] + result[j - 1];
        }
        
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(result[n]);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        final int MAX = 1_000_000;
        int[] n = new int[MAX + 1];
        Arrays.fill(n, Integer.MAX_VALUE);
        n[1] = 0;
        n[2] = 1;
        n[3] = 1;
        for (int i = 4; i < n.length; i++) {
            if (i % 3 == 0) n[i] = Math.min(n[i], n[i / 3] + 1);
            if (i % 2 == 0) n[i] = Math.min(n[i], n[i / 2] + 1);
            n[i] = Math.min(n[i], n[i - 1] + 1);
        }
        System.out.println(n[val]);
    }
}

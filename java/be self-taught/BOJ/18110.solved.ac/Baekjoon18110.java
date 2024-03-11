import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon18110 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        solve(arr.clone());
    }

    private static void solve(int[] arr) {
        int exNum = (int) Math.round(arr.length * 0.15);
        double total = 0;
        double number = 0;
        for (int i = exNum; i < n - exNum; i++) {
            total += arr[i];
            number++;
        }
        System.out.println((int) Math.round(total / number));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2342 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[1]);
        String[] asStrings = br.readLine().split(" ");
        arr = Arrays.stream(asStrings).mapToInt(Integer::parseInt).toArray();
        int[] arrclone = Arrays.stream(asStrings).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arr).sum();
        Arrays.sort(arrclone);
        solve(arrclone[arrclone.length-1], sum);
    }

    public static void solve(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < arr.length; i++) { // 되는지 확인
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println(start);
    }
}

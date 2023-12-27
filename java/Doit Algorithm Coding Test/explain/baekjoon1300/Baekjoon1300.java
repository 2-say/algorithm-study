import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int mid = 0;
        int start = 1;
        int end = k;
        int answer = 0;

        while (start <= end) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                mid = (start + end) / 2;
                if ((mid / i) > n)
                    sum += n;
                else
                    sum += mid / i;
            }
            if (sum < k) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

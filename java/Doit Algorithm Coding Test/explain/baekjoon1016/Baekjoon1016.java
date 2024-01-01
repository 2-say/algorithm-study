import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i < max; i++) {
            long pow = i * i;
            long start_idx = min / pow;
            if (min % pow != 0)
                start_idx++;
            for (long j = start_idx; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i])
                ans++;
        }

        System.out.println(ans);
    }

}

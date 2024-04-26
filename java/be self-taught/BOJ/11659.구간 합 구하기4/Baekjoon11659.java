import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s = a.clone();
        s[0] = a[0];
        
        for(int i = 1; i < N; i++) {
            s[i] = (s[i-1] + a[i]);
        }

        for(int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken())-1;
            if(n == 0) System.out.println(s[m]);
            else System.out.println(s[m] - s[n-1]);
        }
    }
}

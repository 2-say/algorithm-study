import java.io.*;
import java.util.*;

class Main {

    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
    }

    static void solve() {
        int s = 0, e = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(s < N && e < N) {
            if(sum <= S) {
                if(sum == S && min > e-s) min = e-s;
                sum += arr[e++];
            } else if(sum > S) {
                if(min > e-s) min = e-s;
                sum -= arr[s++];
            }
        }

        while(s < N && sum >= S) {
            if(min > e-s) min = e-s;
                sum -= arr[s++];
        }


        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
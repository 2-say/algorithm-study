import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i ; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[arr.length-1]);
    }
}
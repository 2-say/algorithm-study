import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] d = new long[1_000_001];
        int n = Integer.parseInt(br.readLine());
        d[1] = 0; //1명이면 자신것을 써야함.
        d[2] = 1; //서로 교환 1가지 경우
        for(int i = 3 ; i <= n; i++)
            d[i] = ((i-1) * (d[i-1] + d[i-2])) % 1_000_000_000;
        System.out.println(d[n]);
    }
}

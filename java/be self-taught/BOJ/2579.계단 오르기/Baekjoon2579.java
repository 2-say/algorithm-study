import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {
    static int n;
    static int max;
    static Integer[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        score = new int[n+1];
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++)
            score[i] = Integer.parseInt(br.readLine());
        
        dp[0] = 0;
        dp[1] = score[1];
        if(n >= 2) {
           dp[2] = score[2] + score[1];
        }
        
        System.out.println(find(n));
    }   

    public static int find(int n) {
        //값이 없을 경우 재귀 탐색 
        if(dp[n] == null)
            dp[n] = Math.max(find(n-2) , find(n-3) + score[n-1]) + score[n] ;
        // find(n-3) + score[n-1]을 함으로써 연속되지 않은 경우를 선별
        return dp[n];
    }
    
    
}

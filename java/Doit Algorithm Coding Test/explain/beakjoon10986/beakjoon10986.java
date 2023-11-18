package explain.beakjoon10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon10986 {
    public static void main(String[] args) throws IOException {
        //선언부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] iStrings = br.readLine().split(" "); //입력값
        String[] arrStrings = br.readLine().split(" "); //입력 배열
        int n = Integer.parseInt(iStrings[0]);
        int m = Integer.parseInt(iStrings[1]);
        int[] cnt = new int[m]; 
        int[] sarr = new int[n]; //구간합 배열
        long ans=0;

         //구간합 구하기 
        sarr[0]= Integer.parseInt(arrStrings[0]);
        cnt[sarr[0]%m]++;
        for (int i = 1 ; i< arrStrings.length; i++) {
            sarr[i] = (Integer.parseInt(arrStrings[i]) + sarr[i-1] + sarr[i]) % m ; 
            cnt[sarr[i]]++;
        }
        ans = cnt[0]; //개별로 나눈 값 개수도 추가 %M == 0

        //콤비네이션 계산하기
        for(int i=0; i < m ; i++)
        {
            ans += (long)cnt[i] * (cnt[i]-1)/2;
        }
        System.out.println(ans);
    }
}

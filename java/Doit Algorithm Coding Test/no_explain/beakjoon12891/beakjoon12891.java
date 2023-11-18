package no_explain.beakjoon12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon12891 {

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstStringValue = br.readLine().split(" ");   //9 8
        String[] secondStringValue =  br.readLine().split("");                    //CCTGGATTG
        String[] thirdStringValue = br.readLine().split(" ");   //2 0 1 1
        int val1 = Integer.parseInt(firstStringValue[0]);  //9
        int val2 = Integer.parseInt(firstStringValue[1]);  //8
        int[] mychkarr = new int[4];
        int count=0;

        //기본 값 셋팅 
        for(int i=0; i < val2 ; i++)
        {
            if ("A".equals(secondStringValue[i])) mychkarr[0]++;
            if ("C".equals(secondStringValue[i])) mychkarr[1]++;
            if ("G".equals(secondStringValue[i])) mychkarr[2]++;
            if ("T".equals(secondStringValue[i])) mychkarr[3]++;
        }
        //기본 값 비밀번호 유효성 체크
        if(check(mychkarr,thirdStringValue)) count ++;
        
        int start;
        for(int j = val2; j < val1; j++)
        {   
            start  = j - val2; //앞번호 값
            //j는 뒤에 번호
          
            //앞번호 빼기
            if ("A".equals(secondStringValue[start])) mychkarr[0]--;
            if ("C".equals(secondStringValue[start])) mychkarr[1]--;
            if ("G".equals(secondStringValue[start])) mychkarr[2]--;
            if ("T".equals(secondStringValue[start])) mychkarr[3]--;

            //뒷번호 올리기
            if ("A".equals(secondStringValue[j])) mychkarr[0]++;
            if ("C".equals(secondStringValue[j])) mychkarr[1]++;
            if ("G".equals(secondStringValue[j])) mychkarr[2]++;
            if ("T".equals(secondStringValue[j])) mychkarr[3]++;

            if(check(mychkarr,thirdStringValue))
            {
                count ++;
            }
        }

        System.out.println(count);
    }

    
    private static boolean check(int[] mychkarr,String[] thirdStringValue) {
        for(int i = 0 ; i < 4; i++)
        {
            if(mychkarr[i] < Integer.parseInt(thirdStringValue[i])) return false;
        }
        return true;
    }
}
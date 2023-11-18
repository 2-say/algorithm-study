package explain.beakjoon11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class beakjoon11003_v1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg1  = br.readLine().split(" ");
        String[] arg2 = br.readLine().split(" ");

        int N  = Integer.parseInt(arg1[0]);
        int L  = Integer.parseInt(arg1[1]);

        Integer[] parr = new Integer[L]; //3 

        int[] D  = new int[N];

        for(int i = 0; i < L; i++)
        {
            int ai = i-L+1 ;
            if(ai<0){
                parr[i] = Integer.MAX_VALUE;
            }
            else{ 
                parr[i] = Integer.parseInt(arg2[ai]);
            }
        }
        List<Integer> intList = new ArrayList<>(Arrays.asList(parr));
        D[0] = Collections.min(intList); 

        for(int j = 1 ; j<N ; j++)
        {
            intList.remove(0); //맨 앞 제거
            intList.add(Integer.parseInt(arg2[j])); //뒤에 추가
            D[j] = Collections.min(intList);  //최소값 넣기 
        }

        for (int w : D) {
            System.out.printf("%d ",w );
        }
        
    }
}
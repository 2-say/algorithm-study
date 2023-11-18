package explain.beakjoon1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon1546 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String [] arnum  = br.readLine().split(" ");
        int max = Integer.parseInt(arnum[0]);
        Double [] arr_result = new Double[num];
        Double result = 0.0; 

        for (int i = 0 ; i < num ; i++)
        {
            if(max < Integer.parseInt(arnum[i]))
            {
                max = Integer.parseInt(arnum[i]);
            }
        }
        
        for (int i = 0 ; i < num ; i++)
        {
            arr_result[i] = (Double.parseDouble(arnum[i])/max) * 100.0 ;
            result += arr_result[i];
        }

        
        result /= num; 

        System.out.println(result);


        
        
    }
}

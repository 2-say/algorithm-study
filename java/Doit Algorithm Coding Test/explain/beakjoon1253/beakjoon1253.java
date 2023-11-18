package explain.beakjoon1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class beakjoon1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str_arr = br.readLine().split(" ");
        int[] int_arr = new int[n];
        int sum = 0; 
        int count = 0;

        for(int a = 0; a< str_arr.length; a++){
            int_arr[a] = Integer.parseInt(str_arr[a]);
        }
        Arrays.sort(int_arr);
        
        for(int a =0 ;a<n ; a++){
            long find = int_arr[a];
            int i = 0;
            int j = n-1;
            while(i < j)
            {
                    sum = int_arr[i] +  int_arr[j];
                    if(sum == find)
                    {
                        if(i != a && j !=a)
                        {
                            count++;
                            break;
                        }
                        else if( i == a)
                        {
                            i++;
                        }
                        else if(j==a){
                            j--;
                        }
                    }
                    else if(sum > find)
                    {
                        j--;
                    }
                    else{
                        i++;
                    }
            }            
        }

        System.out.println(count);
    }
}

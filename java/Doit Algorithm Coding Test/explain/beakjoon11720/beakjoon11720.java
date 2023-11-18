package explain.beakjoon11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon11720 { 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String snum = br.readLine();
        int reuslt = 0 ; 

        char[] cnum = snum.toCharArray();
        
        for(int i = 0 ; i < cnum.length; i++)
        {
            reuslt += cnum[i]- '0';
        }
        
        System.out.println(reuslt);
    }
    
}

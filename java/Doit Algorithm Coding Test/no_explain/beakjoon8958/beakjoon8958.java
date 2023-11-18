package no_explain.beakjoon8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon8958 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int round = Integer.parseInt(br.readLine());
        String s;
        int result[] = new int[round];
        
        for(int i=0; i<round; i++)
        {
            int combo=1;
            s = br.readLine();
            for(int j=0; j< s.length(); j++)
            {
                if(s.charAt(j)=='O')
                {
                    result[i] += combo++;
                }
                else if(s.charAt(j)=='X')
                {
                    combo=1;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }
 
    }
}

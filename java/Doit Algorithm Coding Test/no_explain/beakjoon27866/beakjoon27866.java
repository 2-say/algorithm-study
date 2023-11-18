package no_explain.beakjoon27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon27866 {
    
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        int index = Integer.parseInt(br.readLine());
        System.out.println(word[index-1]);  
    }
}

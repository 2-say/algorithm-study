import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        String answer;
        for(int i = 0; i < 3; i++) {
            String val = br.readLine();
            if(isNumberic(val)) {
                idx = Integer.parseInt(val) + (3-i);
            }
        }
        
        if(idx%3 == 0 && idx %5 == 0)
            answer = "FizzBuzz";
        else if(idx%3 == 0 && idx %5 != 0)
            answer = "Fizz";
        else if(idx%3 != 0 && idx %5 == 0)
            answer = "Buzz";
        else answer = String.valueOf(idx);
        System.out.println(answer);
    }
    
    
    public static boolean isNumberic(String val) {
        try {
           int a = Integer.parseInt(val);
           return true;
        } catch(NumberFormatException e) {
           return false;
        }
    }
}
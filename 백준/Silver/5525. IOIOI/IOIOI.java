import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] input = br.readLine().split("");
        
        StringBuilder P = new StringBuilder();
        P.append("I");
        for(int i = 0; i < n ; i++) {
            P.append("OI");
        }

        int windowSize = P.length();


        StringBuilder tmp = new StringBuilder();
        
        for(int i = 0 ; i < windowSize; i++) {
            tmp.append(input[i]);
        }

        if(tmp.toString().equals(P.toString())) {
            answer++;
        }
        
        for(int i = windowSize; i < input.length; i++) {
            tmp.delete(0,1);
            tmp.append(input[i]);

            if(tmp.toString().equals(P.toString())) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
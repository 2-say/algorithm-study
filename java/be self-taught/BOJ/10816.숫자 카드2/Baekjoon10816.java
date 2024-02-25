import java.io.*;
import java.util.*;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i]))
                map.put(input[i] , map.get(input[i])+1);
            else{
                map.put(input[i], 1);
            }
        }

        br.readLine();
        String[] find = br.readLine().split(" ");
        for(int i = 0 ; i < find.length; i++){  
            if(map.containsKey(find[i]))
                sb.append(map.get(find[i])).append(" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb.toString());
        
    }       
}

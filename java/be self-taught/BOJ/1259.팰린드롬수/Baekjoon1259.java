import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String result = "yes";
            String input = br.readLine();
            if(input.equals("0")){
                break;
            }
            for(int i = 0 ; i < input.length()/2+1; i++) {
                if(input.charAt(i) != input.charAt(input.length()-1-i)){
                    result = "no";
                }
            }
            System.out.println(result);
        }
    }
}

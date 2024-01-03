import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i  < n ; i++){
            String[] input  = br.readLine().split(" ");
            long a = Integer.parseInt(input[0]);
            long b = Integer.parseInt(input[1]);
            long c = Integer.parseInt(input[2]);
            long gcd = gcd(a, b);
            if(c % gcd != 0){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
    private static long gcd(long a, long b){
        while (b != 0) {
            long tmp = a % b;
            a = b; 
            b = tmp;
        }
        return Math.abs(a);
    }
}

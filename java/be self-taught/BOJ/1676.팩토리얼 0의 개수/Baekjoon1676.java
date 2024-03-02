import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("1");
        for(int i = 2; i <=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        int answer = 0;
        int index = result.toString().length()-1;
        while(result.toString().charAt(index) == '0') {
            answer++;
            index--;
        }
        System.out.println(answer);
    }
}

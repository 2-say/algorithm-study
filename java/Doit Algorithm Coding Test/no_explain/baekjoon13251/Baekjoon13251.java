import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Baekjoon13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arr).sum();
        int k = Integer.parseInt(br.readLine());

        BigDecimal all = combination(sum, k);
        
        BigDecimal part = BigDecimal.ZERO;
        for(int i = 0 ; i < n ; i++) {
            part = part.add(combination(arr[i], k));
        }
        double partDouble = part.doubleValue();
        double allDouble = all.doubleValue();
        
        System.out.println(partDouble/allDouble);
    }

    static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = n; i >= 1; i--)
            result = result.multiply(new BigInteger(String.valueOf(i)));
        return result;
    }

    static BigDecimal combination(int n, int r) {
        BigDecimal result;
        result = new BigDecimal(factorial(n).divide(factorial(n - r)).divide(factorial(r)));
        return result;
    }
}

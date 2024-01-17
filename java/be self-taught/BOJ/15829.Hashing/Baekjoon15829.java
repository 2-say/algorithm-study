import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Baekjoon15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger cont = BigInteger.valueOf(31);
        BigInteger tmp = BigInteger.valueOf(1);
        String input = br.readLine();
        BigInteger result = BigInteger.valueOf(input.charAt(0) - 96);
        BigInteger mod = BigInteger.valueOf(1234567891);

        for (int i = 1; i < n; i++) {
            int num = input.charAt(i) - 96;
            tmp = tmp.multiply(cont);
            result = result.add(BigInteger.valueOf(num).multiply(tmp));
        }
        result = result.mod(mod);
        System.out.println(result.toString());
    }
}
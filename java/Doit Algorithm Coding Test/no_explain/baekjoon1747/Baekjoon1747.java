import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1747 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    static boolean isPrime(int num) {
        if(num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    static int solve(int n) {
        int num = n - 1;

        while (true) {
            num++;
            String sNum = String.valueOf(num);
            boolean pelN = true;
            for (int i = 0; i < sNum.length(); i++) {
                if (sNum.charAt(i) != sNum.charAt(sNum.length() - 1 - i)) {
                    pelN = false;
                    break;
                }
            }
            if (pelN && isPrime(num)) {
                return num;
            }
        }
    }
}

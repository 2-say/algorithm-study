import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int quotient = n / 5;
        int result = quotient;
        boolean isP = true;

        while (n != (5 * quotient)) {
            if (quotient < 0) {
                isP = false;
                break;
            }
            if ((n - (5 * quotient)) % 3 == 0) {
                result = quotient;
                result += (n - (5 * quotient)) / 3;
                break;
            }
            quotient--;
        }
        if (isP) {
            System.out.println(result);
        } else
            System.out.println(-1);
    }
}

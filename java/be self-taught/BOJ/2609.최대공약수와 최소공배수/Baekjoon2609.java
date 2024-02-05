import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(Math.max(a, b), Math.min(a, b)));
        System.out.println(lcm(Math.max(a, b), Math.min(a, b)));
    }

    static int lcm(int a, int b) {
        int i = 1;
        int result = 1;
        while (a > i || b > i) {
            i++;
            if (a % i == 0 && b % i == 0) {
                result *= i;
                a /= i;
                b /= i;
                i = 1;
            }
        }
        return result * a * b;
    }

    static int gcd(int a, int b) {
        int i = a;
        while (i > 0) {
            if (a % i == 0 && b % i == 0)
                return i;
            i--;
        }
        return i;
    }
}

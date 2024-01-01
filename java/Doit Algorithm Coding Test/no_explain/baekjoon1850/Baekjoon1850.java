import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger b1 = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        BigInteger b2 = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        BigInteger g = b1.gcd(b2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g.intValue(); i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }
}

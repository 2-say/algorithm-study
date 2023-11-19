import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int round = Integer.parseInt(input[0]);
            String stringInput = input[1];

            for (int len = 0; len < stringInput.length(); len++) {
                for (int a = 0; a < round; a++) {
                    System.out.printf("%c", stringInput.charAt(len));
                }
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toLowerCase();

        int[] count = new int[27];
        for (int i = 0; i < input.length(); i++) {
            count[(int) (input.charAt(i) - 96)]++;
        }

        int max = Arrays.stream(count).max().orElseThrow();
        int depcount = 0;
        int indx = 0;

        for (int i = 0; i <= 26; i++) {
            if (max == count[i]) {
                depcount++;
                indx = i;
            }
        }

        if (depcount >= 2) {
            System.out.println("?");
        } else {
            char result = (char) ((indx + 96) - 32);
            System.out.println(result);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputS = br.readLine().split(" ");
        int[] input = Arrays.stream(inputS).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            answer += input[i] * input[i];
        }
        System.out.println(answer % 10);
    }
}

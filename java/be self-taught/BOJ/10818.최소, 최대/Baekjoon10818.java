import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sinput = br.readLine().split(" ");
        int[] input = Arrays.stream(sinput).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        System.out.println(input[0] + " " + input[input.length - 1]);
    }
}

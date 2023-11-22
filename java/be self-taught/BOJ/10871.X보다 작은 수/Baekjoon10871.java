import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nx = br.readLine().split(" ");
        String[] valStrings = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        int x = Integer.parseInt(nx[1]);
        int[] value = Arrays.stream(valStrings).mapToInt(Integer::parseInt).toArray();
        for (int i : value) {
            if (i < x)
                System.out.println(i);
        }
    }
}

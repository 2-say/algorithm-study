import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        
        long[] arr = Arrays.stream(input).mapToLong(Long::parseLong).toArray();
        Long[] iarr = Arrays.stream(arr).boxed().toArray(Long[] :: new);
        
        Arrays.sort(iarr,Collections.reverseOrder());
        
        for (Long i : iarr) {
            System.err.printf("%d",i);
        }
    }
}

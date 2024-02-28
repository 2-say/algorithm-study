import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baekjoon1654 {
    static List<Long> lanLine;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] kn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = kn[0];
        n = kn[1];
        lanLine = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lanLine.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(lanLine);

        if (n == 1 && k == 1) {
            System.out.println(lanLine.get(0));
        } else
            System.out.println(binarySearch(1, lanLine.get(lanLine.size() - 1)));
    }

    private static long possible(long number) {
        long count = 0;
        for (Long l : lanLine) {
            count += (l / number);
        }
        return count;
    }

    private static long binarySearch(long start, long end) {
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            //계속 줄여나감
            if (possible(mid) < n) { 
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return (start + end)/ 2;
    }

}

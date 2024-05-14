import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BigInteger sum = BigInteger.ZERO;

        for (int num : arr) {
            sum = sum.add(BigInteger.valueOf(num));
        }

        Arrays.sort(arr);

        BigInteger num = BigInteger.valueOf(n);
        BigInteger max = sum.subtract(m).divide(num);

        for (int i = 0; i < n - 1; i++) {
            sum = sum.subtract(BigInteger.valueOf(arr[i]));
            num = num.subtract(BigInteger.ONE);

            BigInteger answer = sum.subtract(m).divide(num);
            if (isInteger(answer) && max.compareTo(answer) < 0) {
                max = answer;
            }
        }
        System.out.println(max);
    }

    public static boolean isInteger(BigInteger num) {
        return true; // BigInteger는 항상 정수이므로 true를 반환합니다.
    }
}

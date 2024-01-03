import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println(getPreB(arr));
    }

    private static String getPreB(int[] arr) {
        if (arr.length < 3) {
            if (arr.length == 2 && arr[0] == arr[1]) {
                return String.valueOf(arr[0]);
            }
            return "A";
        } else {
            int c = 0;
            int c1 = 0;
            int c2 = 0;
            c = arr[0];
            c1 = arr[1];
            c2 = arr[2];

            int a;
            int b;

            if (c == c1) {
                a = 1;
                b = 0;
            } else {
                if (Math.abs(c2 - c1) % Math.abs(c1 - c) != 0) {
                    return "B";
                }
                a = (c2 - c1) / (c1 - c);
                b = c1 - (c * a);
            }

            for (int i = 2; i < arr.length; i++) {
                if(arr[i-1] * a + b  != arr[i]){
                    return "B";
                }
            }
            return String.valueOf((arr[arr.length-1] * a + b));
        }
    }

}
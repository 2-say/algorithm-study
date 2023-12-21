import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Baekjoon1517 {

    static int[] sorted;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        sorted = new int[n];
        answer = 0;
        divide(arr, 0, n - 1);
        System.out.println(answer);
        System.out.println(Arrays.toString(sorted));
    }

    static void conquer(int[] arr, int start, int mid, int end) {
        int sortedInd = start;
        int divide1 = start;
        int divide2 = mid + 1;
        while (divide1 <= mid && divide2 <= end) {
            if (arr[divide1] > arr[divide2]) {
                sorted[sortedInd] = arr[divide2];
                answer += divide2 - sortedInd;
                sortedInd++;
                divide2++;
            } else {
                sorted[sortedInd++] = arr[divide1++];
            }
        }

        if (divide1 > mid) {
            for (int i = divide2; i <= end; i++) {
                sorted[sortedInd++] = arr[i];
            }
        } else {
            for (int i = divide1; i <= mid; i++) {
                sorted[sortedInd++] = arr[i];
            }
        }
        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }

    static void divide(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            divide(arr, start, mid);
            divide(arr, mid + 1, end);
            conquer(arr, start, mid, end);
        }
    }
}
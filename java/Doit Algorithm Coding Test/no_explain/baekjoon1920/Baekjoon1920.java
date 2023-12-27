import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int n1 = Integer.parseInt(br.readLine());
        String[] findNum = br.readLine().split(" ");
        int[] findArr = Arrays.stream(findNum).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        for (int i = 0; i < findArr.length; i++) {
            binarySearch(arr, 0, findArr.length - 1, findArr[i]);
        }
    }

    static void binarySearch(int[] arr, int start, int end, int findNum) {
        int mid = (start + end) / 2;
        if (start > end) {
            System.out.println(0);
            return;
        }
        if (mid >= 0 && mid < arr.length && arr[mid] == findNum) {
            System.out.println(1);
            return;
        } else if (mid >= 0 && mid < arr.length && arr[mid] < findNum) {
            binarySearch(arr, mid + 1, end, findNum);
        } else {
            binarySearch(arr, start, mid - 1, findNum);
        }
    }
}

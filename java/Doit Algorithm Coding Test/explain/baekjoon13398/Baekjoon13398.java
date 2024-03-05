import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon13398 {
    static int[] arr;
    static int n;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 원소의 개수
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] max = new int[arr.length];
        tmp = arr.clone(); // 임시로 만들고

        int[] leftMax = front(max.clone());    
        int[] rightMax = back(max.clone());
        
        int maxR = Integer.MIN_VALUE;
        for(int i = 1 ; i < arr.length-1; i++) {
            int result1 = 0;
            int result2 = 0;
            result1 = leftMax[i-1];
            result2 = rightMax[i+1];
            if(maxR < result1 + result2)
                maxR = result1 + result2;
        }
        if(maxR < maxResult(leftMax)) {
            maxR = maxResult(leftMax);
        }
        if(maxR < maxResult(rightMax)) {
            maxR = maxResult(rightMax);
        }
        System.out.println(maxR);
    }

    public static int[] front(int[] max) {
        max[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (max[i - 1] + arr[i] < arr[i]) {
                max[i] = arr[i];
            } else {
                max[i] = max[i - 1] + arr[i];
            }
        }
        return max;
    }

    public static int[] back(int[] max) {
        max[max.length - 1] = arr[arr.length - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max[i + 1] + arr[i] < arr[i]) {
                max[i] = arr[i];
            } else {
                max[i] = max[i + 1] + arr[i];
            }
        }
        return max;
    }

    private static int maxResult(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i< arr.length; i++ ){
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}

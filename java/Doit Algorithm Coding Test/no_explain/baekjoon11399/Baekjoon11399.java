import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputString = br.readLine().split(" ");
        int numArr[] = Arrays.stream(inputString).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);
        System.out.println(calculateTime(numArr.clone()));
    }

    static int calculateTime(int arr[]) {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        for (int i : arr) {
            answer += i;
        }
        return answer;
    }
}
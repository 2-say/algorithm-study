import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Baekjoon11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputString = br.readLine().split(" ");
        int findNum = Integer.parseInt(inputString[1]);
        String[] arrString = br.readLine().split(" ");
        int[] arr = Arrays.stream(arrString).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        System.out.println(arr[findNum-1]);
    }
}
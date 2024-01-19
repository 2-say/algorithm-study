import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Baekjoon2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[10];
        int result = 1;
        result *= Integer.parseInt(br.readLine());
        result *= Integer.parseInt(br.readLine());
        result *= Integer.parseInt(br.readLine());

        for(int i = 0 ; i < String.valueOf(result).length(); i++){
            numArr[String.valueOf(result).charAt(i) - '0']++;
        }

        for (int i : numArr) {
            System.out.println(i);
        }
    }
}
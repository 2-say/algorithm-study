import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n > 32) {
                System.out.println("0");
                br.readLine();
                continue;
            }   

            int min = Integer.MAX_VALUE;
            String[] mbti = br.readLine().split(" ");
            for (int a = 0; a < n - 2; a++) {
                for (int b = a + 1; b < n - 1; b++) {
                    for (int c = b + 1; c < n; c++) {
                        int result = isCal(mbti[a], mbti[b], mbti[c]);
                        if (min > result) {
                            min = result;
                        }
                    }
                }
            }
            System.out.println(min);
        }
    }

    public static int isCal(String mbti1, String mbti2, String mbti3) {
        int ab = 0;
        int ac = 0;
        int bc = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i))
                ab++;
            if (mbti1.charAt(i) != mbti3.charAt(i))
                ac++;
            if (mbti3.charAt(i) != mbti2.charAt(i))
                bc++;
        }
        return ab + ac + bc;
    }
}

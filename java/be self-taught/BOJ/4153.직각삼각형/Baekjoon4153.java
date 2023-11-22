import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Baekjoon4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] triangle = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(st.nextToken());
            }
            if (isAllZero(triangle)) {
                break;
            }
            Arrays.sort(triangle);
            if (triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2] * triangle[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }

    private static boolean isAllZero(int[] list) {
        for (int i = 0; i < 3; i++) {
            if (list[i] != 0)
                return false;
        }
        return true;
    }
}

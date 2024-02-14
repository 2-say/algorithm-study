import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5597 {
    static boolean[] list;
    public static void main(String[] args) throws IOException {
        list = new boolean[31];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 28; i++){
            int c = Integer.parseInt(br.readLine());
            list[c] = true;
        }

        for(int i = 1 ; i <= 30; i++) {
            if(!list[i])
                System.out.println(i);
        }
    }
}

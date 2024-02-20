import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] ox = br.readLine().split("");
            int initPoint = 1;
            int result = 0;
            for (int j = 0; j < ox.length; j++) {
                if(ox[j].equals("O")){
                    result += initPoint;
                    initPoint++;
                }
                else if(ox[j].equals("X"))
                    initPoint = 1;
            }
            System.out.println(result);
        }
    }
}
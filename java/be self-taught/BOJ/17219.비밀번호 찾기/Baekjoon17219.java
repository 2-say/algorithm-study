import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int findN = Integer.parseInt(input[1]);
        Map<String, String> info = new HashMap();
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            info.put(a[0], a[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < findN; i++)
            sb.append(info.get(br.readLine())).append("\n");
        System.out.println(sb.toString());
    }
}

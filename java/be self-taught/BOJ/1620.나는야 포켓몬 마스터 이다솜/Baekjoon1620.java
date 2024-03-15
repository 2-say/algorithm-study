import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Baekjoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> stringMap = new HashMap();
        Map<Integer, String> numberMap = new HashMap();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String v = br.readLine();
            stringMap.put(v, i);
            numberMap.put(i, v);
        }
        for (int i = 0; i < m; i++) {
            String input1 = br.readLine();
            if (input1.charAt(0) > 47 && input1.charAt(0) < 58)
                sb.append(numberMap.get(Integer.parseInt(input1))).append("\n");
            else
                sb.append(stringMap.get(input1)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
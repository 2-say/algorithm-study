import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Baekjoon14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> sMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sMap.put(br.readLine(), 0);
        }
        for (int i = 0; i < m; i++) {
            String val = br.readLine();
            if (sMap.containsKey(val))
                sMap.put(val, sMap.get(val) + 1);
        }
        int result = 0;
        for (Entry val : sMap.entrySet()) {
            if ((int) val.getValue() >= 1) {
                result += (int) val.getValue();
            }
        }
        System.out.println(result);
    }
}

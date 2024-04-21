import java.io.*;
import java.util.*;

public class Baekjoon9375 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                if (map.containsKey(input[1]))
                    map.put(input[1], map.get(input[1]) + 1);
                else
                    map.put(input[1], 1);
            }
            int count = 1;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                //각 분류별로 +1하는 이유 해당 옷만 입을 경우가 있기 때문 공집합 포함
                count *= (e.getValue() + 1);
            }
            //위에서 모두 안입을 경우가 포함되었기 때문에 하나 뺴야함.
            sb.append(count - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}

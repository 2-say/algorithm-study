import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0 ; i  < n + m; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }else {
                map.put(name, 1);
            }
        }
        List<String> order  = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> a : map.entrySet()) {
            if(a.getValue() >= 2){
                order.add(a.getKey());
                
            }
        }

        Collections.sort(order);
        for (String string : order) {
            sb.append(string).append("\n");
        }
        System.out.println(order.size());
        System.out.println(sb.toString());
    }
}

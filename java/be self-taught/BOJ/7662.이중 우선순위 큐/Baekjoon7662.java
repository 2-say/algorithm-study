import java.io.*;
import java.util.*;

public class Baekjoon7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> asc = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int insertCount = 0;
            int ascCount = 0;
            int desCount = 0;
            int currentValue = -1;
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String command = input[0];
                int value = Integer.parseInt(input[1]);
                
                if (command.equals("I")) {
                    desc.add(value);
                    asc.add(value);
                    if (map.containsKey(value)) {
                        map.put(value, map.get(value) + 1);
                    } else
                        map.put(value, 1);
                    insertCount++;
                } else {
                    if (desCount + ascCount < insertCount && value == -1) {
                        ascCount++;
                        while (map.get(asc.peek()) == 0) {
                            asc.poll();
                        }
                        map.put(asc.peek(), map.get(asc.peek()) - 1);
                        asc.poll();
                    } else if (desCount + ascCount < insertCount && value == 1) {
                        desCount++;
                        while (map.get(desc.peek()) == 0) {
                            desc.poll();
                        }
                        map.put(desc.peek(), map.get(desc.peek()) - 1);
                        desc.poll();
                    }
                }
            }

            if (ascCount + desCount >= insertCount) {
                System.out.println("EMPTY");
            } else {
                while (map.get(asc.peek()) == 0) {
                    asc.poll();
                }
                int min = asc.poll();
                while (map.get(desc.peek()) == 0) {
                    desc.poll();
                }
                int max = desc.poll();
                System.out.println(max + " " + min);
            }
        }
    }
}

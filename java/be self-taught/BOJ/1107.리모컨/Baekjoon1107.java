import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Baekjoon1107 {

    static class Info {
        List<Integer> numbers;
        int curr;

        public Info(List<Integer> numbers, int curr) {
            this.numbers = numbers;
            this.curr = curr;
        }
    }

    static boolean[] possibleNum;
    static int[] find;
    static int findNumber;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        find = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < find.length; i++) {
            sb.append(find[i]);
        }
        findNumber = Integer.parseInt(sb.toString());
        possibleNum = new boolean[10];
        int n = Integer.parseInt(br.readLine());
        if (n != 0) {
            int[] broken = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < broken.length; i++) {
                possibleNum[broken[i]] = true;
            }
        }
        
        System.out.println(Math.min(dfs(), Math.abs(findNumber - 100)));
    }

    public static int dfs() {
        Stack<Info> stac = new Stack();
        stac.add(new Info(new ArrayList<>(), 0));
        int min = Integer.MAX_VALUE;
        while (!stac.isEmpty()) {
            Info cur = stac.pop();
            StringBuilder sb = new StringBuilder();
            for (int i : cur.numbers) {
                sb.append(i);
            }

            if (cur.numbers.size() > 0 && cur.numbers.size() <= find.length + 1) {
                int size = String.valueOf(Integer.parseInt(sb.toString())).length();
                int result = size + Math.abs(findNumber - Integer.parseInt(sb.toString()));
                if (result >= 0 && min > result) {
                    min = result;
                }
            }
            if (cur.numbers.size() <= find.length) {
                for (int i = 0; i <= 9; i++) {
                    if (!possibleNum[i]) {
                        cur.numbers.add(i);
                        cur.curr = cur.curr + 1;
                        stac.add(new Info(new ArrayList<>(cur.numbers), cur.curr));
                        cur.curr = cur.curr - 1;
                        cur.numbers.remove(cur.numbers.size() - 1);
                    }
                }
            }
        }

        return min;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Baekjoon9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            List<Character> list = new LinkedList<>();
            for (int j = 0; j < input.length(); j++) {
                list.add(input.charAt(j));
            }

            int si = 0;
            int ei = si + 1;

            while (ei < list.size()) {
                if (si + 1 < list.size() && list.get(si) == '(' && list.get(si + 1) == '(') {
                    si++;
                    ei = si + 1;
                } else if (list.get(si) == '(' && list.get(ei) == ')') {
                    list.remove(si);
                    list.remove(si);
                    si = 0;
                    ei = si + 1;
                } else {
                    ei++;
                }
            }
            if (list.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}

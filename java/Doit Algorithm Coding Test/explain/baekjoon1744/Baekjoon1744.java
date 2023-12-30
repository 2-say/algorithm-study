import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Baekjoon1744 {
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());

        System.out.println(solve());
    }

    static int solve() {
        int ans = 0;
        while (true) {
            if (list.size() > 1) {
                int num1 = list.get(0);
                int num2 = list.get(1);
                int num3 = list.get(list.size() - 2);
                int num4 = list.get(list.size() - 1);
                if (0 > num1 && 0 > num2) // 모두 음수일 때
                {
                    ans += num1 * num2;
                    list.remove(0);
                    list.remove(0);
                } else if (num3 > 1 && num4 > 1) {
                    ans += num4 * num3;
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (list.size() >= 2 && list.get(0) < 0 && list.get(1) == 0) {
            list.remove(0);
            list.remove(0);
        }
        for (Integer i : list) {
            ans += i;
        }
        return ans;

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Baekjoon11047 {

    static List<Integer> sm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);
        sm = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sm.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(solve(money));
    }

    static int solve(int money) {
        int answer = 0;

        for (int i = sm.size() - 1; i >= 0; i--) {
            if (sm.get(i) <= money) {
                answer += (money / sm.get(i));
                money %= sm.get(i);
            }
        }
        return answer;

    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Baekjoon1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (!list.isEmpty() && list.size()>1) {
            int a = list.poll();
            int b = list.poll();
            ans += a + b;
            list.add(a + b);
        }
        System.out.println(ans);
    }
}
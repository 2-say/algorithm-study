import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon1931 {
    static Queue<Time> list = new PriorityQueue<Time>();

    static class Time implements Comparable<Time> {
        int s;
        int e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (e == o.e) {
                return s - o.s;
            }
            return e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            list.add(new Time(s, e));
        }
        System.out.println(solve(list.poll()));
    }

    static int solve(Time first) {
        int ans = 1;
        while (!list.isEmpty()) {
            Time next = list.poll();
            if (first.e <= next.s) {
                ans++;
                first = next;
            }
        }
        return ans;
    }
}

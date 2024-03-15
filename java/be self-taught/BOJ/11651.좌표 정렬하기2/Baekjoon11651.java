import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11651 {

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o) {
            if (o.y == y) {
                return Integer.compare(x, o.x);
            }
            return Integer.compare(y, o.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            que.add(new Point(x, y));
        }
        while (!que.isEmpty()) {
            System.out.printf("%d %d\n", que.peek().x,  que.peek().y);
            que.poll();
        }
    }
}

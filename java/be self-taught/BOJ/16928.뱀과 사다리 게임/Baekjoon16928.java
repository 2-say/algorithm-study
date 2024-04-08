import java.util.*;
import java.io.*;

public class Baekjoon16928 {

    static int[] ladder;
    static int[] snake;
    static int ladderN;
    static int snakeN;
    static int min;
    static boolean[] visited;

    static class Info {
        int x;
        int count;  

        public Info(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ladderAndSnake = br.readLine().split(" ");
        ladderN = Integer.parseInt(ladderAndSnake[0]);
        snakeN = Integer.parseInt(ladderAndSnake[1]);
        ladder = new int[107];
        snake = new int[107];
        visited = new boolean[107];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < ladderN; i++) {
            String[] input = br.readLine().split(" ");
            ladder[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        for (int j = 0; j < snakeN; j++) {
            String[] input = br.readLine().split(" ");
            snake[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(1, 0));
        visited[1] = true;

        while (!que.isEmpty()) {
            Info curr = que.poll();
            visited[curr.x] = true;
            if (curr.x > 100)
                continue;
            if (curr.x == 100) {
                if (min > curr.count)
                    min = curr.count;
            } else {
                for (int i = 1; i <= 6; i++) {
                    int next = curr.x + i;
                    if (snake[next] > 0)
                        next = snake[next];
                    if (ladder[next] > 0)
                        next = ladder[next];

                    if (!visited[next]) {
                        visited[next] = true;
                        que.add(new Info(next, curr.count + 1));
                    }
                }
            }
        }
    }

}

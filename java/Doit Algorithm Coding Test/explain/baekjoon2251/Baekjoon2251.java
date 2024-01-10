import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Baekjoon2251 {

    static List<Integer>[] list;
    static List<Integer> ans;
    static int[] arr;
    static boolean[][][] visited;

    static class Water {
        int a;
        int b;
        int c;

        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        list = new List[3];
        visited = new boolean[201][201][201];
        for (int i = 0; i < 3; i++) {
            list[i] = new ArrayList<>();
        }
        ans = new ArrayList<>();
        bfs();
        Collections.sort(ans);
        for (int i : ans) {
            System.out.printf("%d ", i);
        }
    }

    static void bfs() {
        Queue<Water> que = new ArrayDeque<>();
        que.add(new Water(0, 0, arr[2]));

        while (!que.isEmpty()) {
            Water i = que.poll();
            if (visited[i.a][i.b][i.c])
                continue;
            visited[i.a][i.b][i.c] = true;
            if (i.a == 0)
                ans.add(i.c);
            // A->B
            if (i.a + i.b >= arr[1])
                que.add(new Water((i.a + i.b) - arr[1], arr[1], i.c));
            else
                que.add(new Water(0, i.a + i.b, i.c));
            // A->C
            if (i.a + i.c >= arr[2])
                que.add(new Water((i.a + i.c) - arr[2], i.b, arr[2]));
            else
                que.add(new Water(0, i.b, i.a + i.c));
            // B->A
            if (i.a + i.b >= arr[0])
                que.add(new Water(arr[0], (i.a + i.b) - arr[0], i.c));
            else
                que.add(new Water(i.a + i.b, 0, i.c));
            // B->C
            if (i.b + i.c >= arr[2])
                que.add(new Water(i.a, (i.b + i.c) - arr[2], arr[2]));
            else
                que.add(new Water(i.a, 0, i.b + i.c));
            // C->A
            if (i.c + i.a >= arr[0])
                que.add(new Water(arr[0], i.b, (i.c + i.a) - arr[0]));
            else
                que.add(new Water(i.c + i.a, i.b, 0));
            // C->B
            if (i.c + i.b >= arr[1])
                que.add(new Water(i.a, arr[1], (i.c + i.b) - arr[1]));
            else
                que.add(new Water(i.a, i.c + i.b, 0));
        }
    }
}
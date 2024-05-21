import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int time[];
    static int move[] = new int[] { 1, -1, 2 };
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[100_001];
        time[N] = 0;

        solve();
        System.out.println(time[K]);
        System.out.println(cnt);
    }

    public static void solve() {
        Queue<Integer> que = new ArrayDeque<>();

        if (N == K) {
            cnt++;
            return;
        }

        que.add(N);

        while (!que.isEmpty()) {
            int cur = que.poll();
            // 같아지면 횟수를 센다.
            if (cur == K) {
                cnt++;
            }

            int next;
            for (int i = 0; i < 3; i++) {
                // -1칸 +1칸 *2칸
                if (i == 2)
                    next = cur * move[i];
                else
                    next = cur + move[i];

                if (next < 0 || next > 100_000 || (time[next] != 0 && time[next] < time[cur] + 1))
                    continue;

                time[next] = time[cur] + 1;
                que.add(next);
            }
        }
    }
}
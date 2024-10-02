import java.io.*;
import java.util.*;

class Main {

    static int[] convey;
    static boolean[] hasRobot;  // 로봇이 있는 위치를 확인하기 위한 배열
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        convey = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        hasRobot = new boolean[2 * N];  // 로봇이 있는지 여부를 확인

        System.out.println(solve());
    }

    static int solve() {
        int answer = 0;

        while (true) {
            answer++;

            // 1. 벨트가 회전한다. 로봇도 함께 회전
            rotateWithRobot();

            // 2. 로봇을 이동시킨다.
            moveRobots();

            // 3. 올리는 위치에 로봇을 올린다.
            if (convey[0] > 0 && !hasRobot[0]) {
                hasRobot[0] = true;  // 로봇을 올리고
                convey[0]--;         // 내구도를 감소시킴
            }

            // 4. 내구도가 0인 칸의 개수를 확인한다.
            if (checkDurability()) {
                break;  // 내구도가 0인 칸이 K개 이상이면 종료
            }
        }

        return answer;
    }

    // 1. 벨트와 로봇을 회전
    static void rotateWithRobot() {
        // 벨트를 회전시킴
        int lastConvey = convey[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            convey[i] = convey[i - 1];
            hasRobot[i] = hasRobot[i - 1];
        }
        convey[0] = lastConvey;
        hasRobot[0] = false;  // 로봇이 처음에는 없으므로

        // 내리는 위치에 로봇이 있으면 내린다.
        hasRobot[N - 1] = false;  // N번째 위치에서는 로봇을 무조건 내림
    }

    // 2. 로봇 이동 처리
    static void moveRobots() {
        // 로봇을 이동시킨다. 가장 먼저 올라간 로봇부터 처리
        for (int i = N - 2; i >= 0; i--) {  // N-1은 내려야 하므로, N-2부터 0까지 검사
            if (hasRobot[i] && !hasRobot[i + 1] && convey[i + 1] > 0) {
                // 로봇을 이동할 수 있으면 이동
                hasRobot[i] = false;
                hasRobot[i + 1] = true;
                convey[i + 1]--;  // 내구도 감소
            }
        }

        // 내리는 위치에 도달한 로봇은 즉시 내린다.
        hasRobot[N - 1] = false;
    }

    // 4. 내구도가 0인 칸이 K개 이상인지 확인
    static boolean checkDurability() {
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (convey[i] == 0) {
                count++;
            }
        }
        return count >= K;
    }
}

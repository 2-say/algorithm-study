import java.io.*;
import java.util.*;

public class Baekjoon1068 {

    static int[] prArr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int remove = Integer.parseInt(br.readLine());
        removeNode(remove);
        System.out.println(Arrays.toString(prArr));
        boolean[] answer;
        answer = leaf();
        solve(answer);
    }

    static boolean[] leaf() {
        boolean[] anser = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (prArr[i] >= 0 && prArr[i] < n) {
                anser[prArr[i]] = true;
            }
            if (prArr[i] == -2 || prArr[i] == -1)
                anser[i] = true;
        }
        return anser;
    }

    static void solve(boolean[] answer) {
        int result = 0;

        if (isOneleft()) {
            System.out.println(1);
        } else {
            for (int i = 0; i < n; i++) {
                if (!answer[i])
                    result++;
            }
            System.out.println(result);
        }
    }

    static void removeNode(int remove) {
        prArr[remove] = -2;
        for (int i = 0; i < n; i++) {
            if ((i != remove) && find(i, remove))
                prArr[i] = -2;
        }
    }

    static boolean isOneleft() {
        int minus2 = 0;
        int minus1 = 0;
        for (int i = 0; i < n; i++) {
            if (prArr[i] == -1)
                minus1++;
            if (prArr[i] == -2)
                minus2++;
        }
        if (minus1 == 1 && minus2 == n - 1)
            return true;
        else
            return false;
    }

    static boolean find(int a, int remove) {
        if (prArr[a] == -1)
            return false;
        else if (prArr[a] == remove || prArr[a] == -2)
            return true;
        else
            return find(prArr[a], remove);
    }
}

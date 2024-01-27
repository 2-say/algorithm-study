import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Baekjoon11505 {

    static int j;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 트리 배열 초기화
        j = 0;
        while (Math.pow(2, j) < n)
            j++;
        tree = new long[(int) Math.pow(2, j) * 2];
        Arrays.fill(tree, 1);

        // 트리 배열 입력
        for (int i = 0; i < n; i++) {
            int idx = (int) Math.pow(2, j) + i;
            tree[idx] = Long.parseLong(br.readLine());
        }
        // 부모 트리 초기화
        init();

        for (int i = 0; i < k + m; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (option == 1) {
                update(a, b);
            } else if (option == 2) {
                System.out.println(preMult(a, (int) b));
            }
        }
    }

    static void init() {
        int last = (int) Math.pow(2, j) * 2;
        for (int i = last - 2; i > 0; i -= 2) {
            tree[i / 2] = tree[i] * tree[i + 1];
        }
    }

    static void update(int a, long val) {
        int idx = (int) Math.pow(2, j) + a - 1; // a번째
        tree[idx] = val;
        while (idx > 1) {
            if (idx % 2 == 1) {
                tree[idx / 2] = tree[idx - 1] * tree[idx];
            } else if (idx % 2 == 0) {
                tree[idx / 2] = tree[idx + 1] * tree[idx];
            }
            idx /= 2;
        }
    }

    static long preMult(int a, int b) {
        int aInd = (int)Math.pow(2, j) + a - 1;
        int bInd = (int)Math.pow(2, j) + b - 1;
        long result = 1;
        while (aInd <= bInd) {
            if (aInd % 2 == 1) {
                result = result *  tree[aInd] % 1_000_000_007 ;
            }
            if (bInd % 2 == 0) {
                result = result * tree[bInd] % 1_000_000_007;
            }
            aInd = (aInd + 1) / 2;
            bInd = (bInd - 1) / 2;
        }
        return result;
    }

}
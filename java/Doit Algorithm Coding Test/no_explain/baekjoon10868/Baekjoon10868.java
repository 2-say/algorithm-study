import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10868 {
    static long[] tree;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 원소개수
        int m = Integer.parseInt(st.nextToken()); // 주어지는 구간

        // 배열 선언
        k = 0;
        while (Math.pow(2, k) < n)
            k++;

        tree = new long[(int) Math.pow(2, k) * 2];
        Arrays.fill(tree, Integer.MAX_VALUE);

        // 리프 노드 입력 받기
        for (int i = 0; i < n; i++) {
            tree[(int) Math.pow(2, k) + i] = Integer.parseInt(br.readLine());
        }

        // 부모트리 채워가기
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(min(a, b));
        }
    }

    static void init() {
        int start = (int) Math.pow(2, k) * 2;
        for (int i = start - 2; i > 0; i -= 2) {
            tree[i / 2] = Math.min(tree[i], tree[i + 1]);
        }
    }

    static long min(int a, int b) {
        // a~b 최소값 구하기
        int aInd = (int) Math.pow(2, k) + a - 1;
        int bInd = (int) Math.pow(2, k) + b - 1;
        long result = Integer.MAX_VALUE;
        while (aInd <= bInd) {

            if (aInd % 2 == 1) {
                result = Math.min(result, tree[aInd]);
            }
            if (bInd % 2 == 0) {
                result = Math.min(result, tree[bInd]);
            }
            aInd = (aInd + 1) / 2;
            bInd = (bInd - 1) / 2;
        }
        return result;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2042 {

    static long[] tree;
    static int j; // 2^k 에서 k

    public static void main(String[] args) throws IOException {
        // 세그먼트 트리 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간 합

        // 트리 배열 크기 정하기 위해서 2^k 에서 k 구함
        j = 0;
        while (Math.pow(2, j) < n)
            j++;
        tree = new long[(int) Math.pow(2, j) * 2];

        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            tree[(int) Math.pow(2, j) + i] = Long.parseLong(br.readLine());
        }
        // 구간합 배열 완성
        init((int) Math.pow(2, j));

        // 변경,구간합계산
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (option == 1)
                update(a, b);
            else if (option == 2) {
                System.out.println(prefixSum(a, (int)b));
            }
        }
    }

    static void init(int n) {
        // 두개씩 묶어서 왼쪽 계산
        // A[n] = A[2n] + A[2N+1];
        // 0번째 칸은 비워둔다.
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[(2 * i) + 1];
        }
    }

    static void update(int ind, long change) {
        // 업데이트 과정
        // ind 번째수를 change로 변경
        int indx = ((int) Math.pow(2, j) + ind - 1);
        long diff = change - tree[indx]; // 차이값 계산

        // 부모 노드로 올라가면서 업데이트
        while (indx > 0) {
            tree[indx] += diff;
            indx = indx / 2;
        }
    }

    static long prefixSum(int a, int b) {
        // a ~ b 까지 합
        // 해당 인덱스로 변경
        int aInd = (int) Math.pow(2, j) + a - 1;
        int bInd = (int) Math.pow(2, j) + b - 1;
        long result = 0;

        while (aInd <= bInd) {
            if (aInd % 2 == 1){
                result += tree[aInd];
            }
            if (bInd % 2 == 0){
                result += tree[bInd];
            }
            // 부모 노드로 이동
            aInd = (aInd+1) / 2 ;
            bInd = (bInd-1) / 2 ;
        }
        return result;
    }

}
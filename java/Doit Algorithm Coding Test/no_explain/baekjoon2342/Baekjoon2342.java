import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Baekjoon2342 {

    static int[] arr;
    static int minScore = Integer.MAX_VALUE;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        memo = new int[arr.length][5][5];
        int[] lr = new int[2];
        System.out.println(solve(0, lr.clone()));
    }

    public static int solve(int index, int[] lr) {
        if (0 == arr[index]) {
            return 0;
        }else if(memo[index][lr[0]][lr[1]] != 0){
            return memo[index][lr[0]][lr[1]];
        }

        int score = Integer.MAX_VALUE;

        for (int i = 0; i < 2; i++) {
            int value = lr[i];
            int[] copy = lr.clone();

            if (value == 0) {
                copy[i] = arr[index];
                score = Math.min(score, solve(index + 1, copy) + 2);
                if (arr[index] == 0) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy)+1,score);
                }
            }
            if (value == 1) {
                if (arr[index] == 3) {
                    copy[i] = arr[index];
                    score = Math.min(score, solve(index + 1, copy) + 4);
                }
                if (arr[index] == 2 || arr[index] == 4) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) + 3,score);
                }
                if (arr[index] == 1) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy)+1,score);
                }
            }
            if (value == 2) {
                if (arr[index] == 4) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy)+4,score);
                }
                if (arr[index] == 1 || arr[index] == 3) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy)+3,score);
                }
                if (arr[index] == 2) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy)+1,score);
                }
            }
            if (value == 3) {
                if (arr[index] == 1) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) +4,score);
                }
                if (arr[index] == 2 || arr[index] == 4) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) +3, score);
                }
                if (arr[index] == 3) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) + 1, score);
                }
            }
            if (value == 4) {
                if (arr[index] == 2) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) +4,score);
                }
                if (arr[index] == 1 || arr[index] == 3) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) +3, score);
                }
                if (arr[index] == 4) {
                    copy[i] = arr[index];
                    score = Math.min(solve(index + 1, copy) + 1, score);
                }
            }
        }
        
        return memo[index][lr[0]][lr[1]] = score;
    }
}
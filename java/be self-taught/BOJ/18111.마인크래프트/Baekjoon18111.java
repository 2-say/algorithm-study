import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baekjoon18111 {
    // 블록 캐기 2초
    static int[][] map;
    static int n;
    static int m;
    static int b;

    static class Result implements Comparable<Result> {
        int time;
        int hight;

        public Result(int time, int hight) {
            this.time = time;
            this.hight = hight;
        }

        @Override
        public int compareTo(Result o) {
            if (time == o.time) {
                return Integer.compare(o.hight, hight);
            }
            return Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0]; // 가로
        m = arr[1]; // 세로
        b = arr[2]; // 인벤토리 블록

        // 입력
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = findMaxBlock();
        int min = findMinBlock();

        Result r = bruteForce(max, min);
        System.out.println(r.time + " " + r.hight);
    }

    private static Result bruteForce(int max, int min) {
        List<Result> resultList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            Result r = flatter(i);
            resultList.add(r);
        }
        Collections.sort(resultList);
        return resultList.get(0);
    }

    private static Result flatter(int height) {
        int time = 0;
        int currItem = b; // 현재 소지한 아이템
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(height == map[i][j]) {
                    continue;
                }
                // 깎는다.
                else if (height < map[i][j]) { 
                    time += 2 * (map[i][j] - height);
                    currItem += (map[i][j] - height);
                }
                //블록 채운다.
                else if (height > map[i][j]) { 
                    int needBlock = height - map[i][j];
                    currItem -= needBlock;
                    time += (needBlock);
                }
            }
        }

        if(currItem < 0){
            return new Result(99999999, height);
        }else{
            return new Result(time, height);
        }
    }

    private static int findMinBlock() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min > map[i][j]) 
                    min = map[i][j];
            }
        }
        return min;
    }

    private static int findMaxBlock() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < map[i][j])
                    max = map[i][j];
            }
        }
        return max;
    }
}

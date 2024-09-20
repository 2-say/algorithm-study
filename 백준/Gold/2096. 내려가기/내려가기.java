import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static Integer[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new Integer[N+1][3][2];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < 3; i++) {
            int v1 = dfs(0, i);
            if(max < v1) max = v1;
            int v2 = dfsMin(0, i);
            if(min > v2) min = v2;
        }

        System.out.println(max + " " + min);
    }
    
    //최대값 구하기
    static int dfs(int x, int y) {
        if(x == N-1) return map[x][y];
        if(dp[x][y][0]!= null) return dp[x][y][0];
        
        int max = 0;
        int nX = x+1;
        int nY = 0;

        for(int idx=-1; idx<2; idx++) {
            nY = y + idx;
            if(nY < 0 || nY > 2) continue;
            max = Math.max(max, dfs(nX,nY));
        }
        max += map[x][y]; //결과 만들고
        return dp[x][y][0] = max; //자기값 리턴
    }

    static int dfsMin(int x, int y) {
        if(x == N-1) return map[x][y];
        if(dp[x][y][1]!= null) return dp[x][y][1];
        
        int min = Integer.MAX_VALUE;
        int nX = x+1;
        int nY = 0;

        for(int idx=-1; idx<2; idx++) {
            nY = y + idx;
            if(nY < 0 || nY > 2) continue;
            min = Math.min(min, dfsMin(nX,nY));
        }
        min += map[x][y]; //결과 만들고
        return dp[x][y][1] = min; //자기값 리턴
    }
}
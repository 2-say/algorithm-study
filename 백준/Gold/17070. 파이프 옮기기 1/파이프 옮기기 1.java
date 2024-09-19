import java.io.*;
import java.util.*;

class Main {

    static int N;
    static boolean[][] map;
    static int answer;

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        
        for(int i = 0 ; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(input[j]) == 1) map[i][j] = true;
            }
        }
        //1 = 가로 2 = 세로 3 = 대각선
        dfs(0,1,1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int form) {
        if(x < 0 || y < 0 || x >= N || y >= N || map[x][y]) return;
        if(form == 3) {
            if(map[x][y-1] || map[x-1][y]) return;
        }
        
        if(x== N-1 && y == N-1) {
            answer++;
        } else {
            if(form == 1) {
                dfs(x, y+1, 1);
                dfs(x+1, y+1, 3);
            }
            else if(form == 2) {
                dfs(x+1, y, 2);
                dfs(x+1, y+1, 3);
            }
            else if(form == 3) {
                dfs(x, y+1, 1);
                dfs(x+1, y, 2);
                dfs(x+1, y+1, 3);
            }
        }
    }
}
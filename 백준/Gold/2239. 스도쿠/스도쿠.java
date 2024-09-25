import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static List<P> list;
    static boolean isEnd;

    static class P {
        int x;
        int y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new ArrayList<>();

        for(int i = 0 ; i < 9; i++) {
            String[] in = br.readLine().split("");
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                if(map[i][j] == 0) list.add(new P(i,j));
            }
        }

        solve(0);
        printSuduku();
    }


    static void solve(int idx) {
        if(idx >= list.size()) {
            isEnd = true;
            return;
        }

        P p = list.get(idx);

        // 최적화 하려면 행, 열 체크하기
        for(int i = 1; i <= 9; i++) {
            boolean flag;

            if (checkPart(i, p) && checkRC(i, p)) {
                map[p.x][p.y] = i;
                solve(idx+1);
                if(isEnd) return;
                map[p.x][p.y] = 0;
            }
        }
    }

    static boolean checkPart(int val, P p) {
        int x = (p.x / 3) * 3;
        int y = (p.y / 3) * 3;
        
        for(int i = x; i < x+3 ; i++) {
            for(int j = y; j < y+3; j++) {
                if(map[i][j] == val) return false; 
            }
        }

        return true;
    }

    static boolean checkRC(int val, P p) {
        for (int j = 0; j < 9; j++) {
            if (map[p.x][j] == val || map[j][p.y] == val) return false;
        }
        return true;
    }

    static void printSuduku() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
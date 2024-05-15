import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
 *  3 3
IOX
OXP
XPP
 * 
 */


class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String[][] map;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];
        answer = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j].equals("I")) {
                    solve(i,j);
                }
            }
        }

        if(answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    
    
    }


    static void solve(int sX, int sY) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Stack<Point> stac = new Stack<>();
        stac.add(new Point(sX, sY));
        visited[sX][sY] = true;

        while(!stac.isEmpty()) {
            Point cur = stac.pop();

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + cur.x;
                int nY = dy[i] + cur.y;

                if(isValid(nX, nY)) {
                    if(map[nX][nY].equals("P")) answer++;
                    visited[nX][nY] = true;
                    stac.add(new Point(nX, nY));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x < map.length && y < map[0].length && !map[x][y].equals("X") && !visited[x][y];
    }
    

}

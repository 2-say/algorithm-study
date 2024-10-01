import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ir = Integer.parseInt(st.nextToken());
        int ic = Integer.parseInt(st.nextToken());
        int id = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solve(ir, ic, id));
    }

    static int solve(int r, int c, int d) {
        int count = 0;

        while(true) {

            //현재칸을 청소한다.
            if(!visited[r][c]) {
                count++;
                visited[r][c] = true;
            }

            //주변 내칸 중 청소 되지 않는 칸이 있는 경우 
            if(findArroundDust(r, c)) {
                for(int i = 0; i < 4; i++) {
                    d--;
                    if(d < 0) d = 3;

                    if(isFrontDust(r,c, d)) {
                        r = r + dx[d];
                        c = c + dy[d];
                        break;
                    } 
                }
            } else {
                //뒷 방향
                int backD;
                if(d >= 2) backD = d - 2;
                else backD = d + 2; 
                
                //뒷 방향 좌표
                int nX = r + dx[backD];
                int nY = c + dy[backD];

                //후진 가능여부
                if(isBackValid(nX,nY)) {
                    r = r + dx[backD];
                    c = c + dy[backD];
                } else {
                    break;
                }
            }
        }
        
        return count;
    }

    static boolean isFrontDust(int curX, int curY, int D) {
        int nX = curX + dx[D];
        int nY = curY + dy[D];
        if(isValid(nX,nY)) {
            return true;
        }
        return false;
    }


    static boolean findArroundDust(int r, int c) {
        
        for(int i = 0; i < 4; i++) {
            int nX = r + dx[i];
            int nY = c + dy[i];

            if(isValid(nX, nY)) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && !visited[r][c] && map[r][c] != 1;
    }

    static boolean isBackValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && map[r][c] != 1;
    }




}
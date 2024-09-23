import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int answer;
    static int[][] map;
    static int[][] temp;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<P> infected;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<P> virusList = new ArrayList<>();
        map = new int[N][M];
        answer = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                if(map[i][j]==2) virusList.add(new P(i, j));
            }
        }

        infected = new ArrayList<>();
        temp = new int[N][M];
        for(int i = 0; i < N; i++) temp[i] = map[i].clone();


        //현재 지도에서 색칠하기
        //3은 0 이었다가 감염된 곳을 표시
        visited = new boolean[N][M];
        for(P vi : virusList)
            dfs(vi.x, vi.y, 3);


        //3으로 변환 된곳을 List에 넣어서 순회하자 
        for(int i = 0; i < infected.size()-2; i++) {
            for(int j = i+1; j < infected.size()-1; j++) {
                for(int k = j+1; k < infected.size(); k++) {

                    //원래 맵으로 교체
                    for(int l = 0; l < N; l++) {
                        temp[l] = map[l].clone();
                    }

                    P ii = infected.get(i);
                    P jj = infected.get(j);
                    P kk = infected.get(k);

                    //벽 세우기
                    temp[ii.x][ii.y] = 1;
                    temp[jj.x][jj.y] = 1;
                    temp[kk.x][kk.y] = 1;


                    visited = new boolean[N][M];
                    //바이러스 전파
                    for(P vi : virusList)
                        checkWall(vi.x, vi.y, 3);

                    //안전지대 카운트
                    int val = countSafeZone();
                    if(answer < val) answer = val;
                }
            }
        }

        System.out.println(answer);
    }


    //맵 탐색
    static void dfs(int sX, int sY, int color) {
        Stack<P> stac = new Stack();
        stac.add(new P(sX, sY));
        visited[sX][sY] = true;

        while(!stac.isEmpty()) {
            P cur = stac.pop();

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + cur.x;
                int nY = dy[i] + cur.y;

                if(isValid(nX, nY)) {
                    visited[nX][nY] = true;
                    if(color == 3) infected.add(new P(nX, nY));
                    temp[nX][nY] = color;
                    stac.add(new P(nX, nY));
                }
            }
        }
    }


    //맵 탐색
    static void checkWall(int sX, int sY, int color) {
        Stack<P> stac = new Stack();
        stac.add(new P(sX, sY));
        visited[sX][sY] = true;

        while(!stac.isEmpty()) {
            P cur = stac.pop();

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + cur.x;
                int nY = dy[i] + cur.y;

                if(isValid(nX, nY)) {
                    visited[nX][nY] = true;
                    temp[nX][nY] = color;
                    stac.add(new P(nX, nY));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && temp[x][y] == 0;
    }

    static int countSafeZone() {
        int count = 0;
        for(int i = 0 ; i < N; i++) {
            for(int j =0; j < M; j++) {
                if(temp[i][j] == 0) count++;
            }
        }
        return count;
    }   
    
    
}
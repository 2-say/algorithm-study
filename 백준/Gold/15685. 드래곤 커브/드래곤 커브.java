import java.io.*;
import java.util.*;


class Main {
    static final int RIGHT = 0;
    static final int UP = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;
    static boolean[][] map;
    static List<Integer> directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directions = new ArrayList<>();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            directionCheck(d,g);
            //꼭지점 그리기
            drawVertex(x, y);
        }

        
        //사각형 개수 체크
        int result = checkSquare();
        System.out.println(result);
    }

    //방향 기록하기
    static void directionCheck(int d , int g) {
        //처음 방향 저장
        directions.add(d);
        //상 좌 하 우 방향으로 꺾임
        while(g-- > 0) {
            //뒤에서 꺼내서
            for(int i = directions.size()-1; i >=0 ; i--) {
                int curD = directions.get(i);
                curD++;
                if(curD > 3) curD = 0;
                directions.add(curD);
            }
        }
    }

    //시작 지점 기준 Map 그리기
    static void drawVertex(int sX, int sY) {
        map[sX][sY] = true;
        for(int d : directions) {
            if(d == RIGHT) {
                sX++;
            } else if(d == UP) {
                sY--;            
            } else if(d == LEFT) {
                sX--;
            } else if(d == DOWN) {
                sY++;            
            }
            map[sX][sY] = true;
        }
    }

    static int checkSquare() {
        int count = 0;

        for(int i = 0; i < 100; i++) {
            for(int j= 0; j < 100; j++) {
                if(map[i][j] && map[i+1][j+1] && map[i+1][j] && map[i][j+1]) count++; 
            }
        }
        return count;
    }
}
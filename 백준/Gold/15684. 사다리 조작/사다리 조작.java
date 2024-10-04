import java.io.*;
import java.util.*;

class Main {
    static List<Layer> originLine; //원래 있는 가로선들
    static List<Layer> addableLine; //추가 가능한 가로선들
    static boolean[][] visited;
    static boolean[][] select;
    static int N;
    static int M;
    static int H;
    static int answer;
    static boolean finish;

    static class Layer {
        int v; //vertical line
        int a; //horizon line number

        Layer(int v, int a) {
            this.v = v;
            this.a = a;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        originLine = new ArrayList<>();
        addableLine = new ArrayList<>();
        visited = new boolean[H][N-1];
        select = new boolean[H][N-1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            originLine.add(new Layer(b, a));
            visited[a][b] = true;
            select[a][b] = true;

            if(b-1 >= 0)
                visited[a][b-1] = true;
            if(b+1 < N-1)
                visited[a][b+1] = true;
        }

        answer = -1;

        //넣을 수 있는 모든 가로선 종류 추가
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N-1; j++) {
                if(!visited[i][j]) {
                    addableLine.add(new Layer(j, i));
                }
            }
        }

        //0개부터 놓을 수 있는 것을 모두 놓았을 때까지 모든 경우 체크
        //만약 정답 나온다면 break;
        for(int i = 0; i <= 3; i++) {
            solve(i, 0, 0);
            if(finish) break;
        }

        System.out.println(answer);
    }

    static void solve(int count, int depth, int idx) {
        if(finish) return;

        if(count == depth) {
            if(checkAnswer()) {
                answer = count;
                finish = true;
            }
            return;
        }

        for(int i = idx; i < addableLine.size(); i++) {
            Layer l = addableLine.get(i);
            if(!visited[l.a][l.v]) {
                //선택 체크 & 방문체크
                visited[l.a][l.v] = true;
                if(l.v-1 >= 0) visited[l.a][l.v-1] = true;
                if(l.v+1 < N-1) visited[l.a][l.v+1] = true;
                select[l.a][l.v] = true;

                solve(count, depth+1, i);

                //선택 체크 & 방문체크
                select[l.a][l.v] = false;
                visited[l.a][l.v] = false;
                if(l.v-1 >= 0) visited[l.a][l.v-1] = false;
                if(l.v+1 < N-1) visited[l.a][l.v+1] = false;
            }
        }
    }

    static boolean checkAnswer() {
        for(int i = 0; i < N-1; i++) {
            int r = 0; //가로줄 위치
            int c = i; //세로줄 위치

            while(r < H) {
                //왼쪽 오른쪽 이동
                if(c-1 >= 0 && select[r][c-1]) c = c-1;
                else if(c < N-1 && select[r][c]) c = c+1;
                //행 내려감
                r++;
            }
            //정답
            if(c != i) return false;
        }
        return true;
    }
}
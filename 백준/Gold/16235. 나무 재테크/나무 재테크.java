import java.io.*;
import java.util.*;


class Main {
    static int[][] add;
    static int[][] map;
    static Queue<Tree> tQue;
    static List<Tree> bList; //번식 가능 리스트
    static int K;
    static int N;
    
    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //땅 크기 N * N
        int M = Integer.parseInt(st.nextToken()); //나무 심은 개수
        K = Integer.parseInt(st.nextToken()); // K년이 지난 후 결과

        tQue = new PriorityQueue<>();
        bList = new ArrayList<>();

        map = new int[N][N];
        add = new int[N][N];

        //처음 양분 초기화
        for(int i = 0; i < N; i++) {
            Arrays.fill(map[i], 5);
        }

        //이후 추가될 양분 맵 
        for(int i = 0; i < N; i++) {
            add[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        //심은 나무 정보
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1 ;
            int y = Integer.parseInt(st.nextToken()) -1 ;
            int age = Integer.parseInt(st.nextToken());
            Tree t = new Tree(x, y, age);
            tQue.add(t);
            //번식 가능 리스트 추가
            if(age % 5 == 0) bList.add(t);
        }

        solve();
    }


    static void solve() {
        int year  = 0; 

        //해당 년도가 되면 종료
        while(year <  K) {
            //봄 & 여름
            summer(spring());
            //가을
            autumn();
            //겨울
            winter();

            year++;
            if(tQue.size() == 0) break;
        }

        System.out.println(tQue.size());
    }

    //봄 
    static Queue<Tree> spring() {
        //어린 순으로 양분먹기
        Queue<Tree> dieTree = new ArrayDeque<>();
        Queue<Tree> tmp = new ArrayDeque<>();

        while(!tQue.isEmpty()) {
            Tree t = tQue.poll();
            //양분이 없으면
            if(map[t.r][t.c] < t.age) {
                dieTree.add(t);
                continue;
            }

            map[t.r][t.c] -= t.age;
            t.age++;

            if((t.age-1) % 5 == 0) {
                bList.remove(t);
            } else if(t.age % 5 == 0) {
                bList.add(t);                
            }
            tmp.add(t);
        }

        //살아있는 것만 다시 넣기
        while(!tmp.isEmpty()) tQue.add(tmp.poll());

        return dieTree;
    }

    static void summer(Queue<Tree> dieTree) {
        //죽은 나무 양분 채우기
        while(!dieTree.isEmpty()) {
            Tree t = dieTree.poll();
            if(t.age % 5 == 0)
                bList.remove(t);
            map[t.r][t.c] += (t.age/2);
        }
    }

    static void autumn() {
        //번식 시도
        int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

        for(Tree t : bList) {
            for(int i = 0; i < 8; i++) {
                int nX = t.r + dx[i];
                int nY = t.c + dy[i];
                
                // 유효한 좌표인지 체크
                if(nX >= 0 && nY >= 0 && nX < N && nY < N) {
                    tQue.add(new Tree(nX, nY, 1));
                }
            }
        }

    }

    //겨울 양분 보충
    static void winter() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] += add[i][j];
            }
        }
    }
}
import java.io.*;
import java.util.*;


class Main {

    static boolean[][] cog;
    static List<Command> cList;

    static class Command {
        int cogN;
        int roatate;

        Command(int c, int r) {
            cogN = c;
            roatate = r;
        }

        @Override
        public String toString() {
            return "[" + cogN + " " + roatate + "]" ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cog = new boolean[4][8];

        for(int i = 0; i < 4; i++) {
            String[] in = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                if(Integer.parseInt(in[j]) == 1) cog[i][j] = true;
            }
        }

        cList = new ArrayList<>();
        int K = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1; 
            int r = Integer.parseInt(st.nextToken()); 
            cList.add(new Command(n,r));
        }
        
        solve();
    }


    static void solve() {

        for(Command c : cList) {
            //돌려야하는지 판별
            List<Command> rList = bfs(c);

            for(Command co : rList) {
                boolean[] tmp = new boolean[8];

                //시계회전
                if(co.roatate == 1) {
                    for(int i = 1; i < 8; i++) {
                        tmp[i] = cog[co.cogN][i-1];
                    }
                    tmp[0] = cog[co.cogN][7];
                } else {
                    for(int i = 0; i < 7; i++) {
                        tmp[i] = cog[co.cogN][i+1];
                    }
                    tmp[7] = cog[co.cogN][0];
                }

                cog[co.cogN] = tmp;
            }
        }

        //점수 계산
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            if(i == 0 && cog[i][0]) answer += 1;
            else if(i == 1 && cog[i][0]) answer += 2;
            else if(i == 2 && cog[i][0]) answer += 4;
            else if(i == 3 && cog[i][0]) answer += 8;
        }

        System.out.println(answer);
    }

    static List<Command> bfs(Command c) {
        Queue<Command> que = new ArrayDeque<>();
        List<Command> rotateCog = new ArrayList<>();
        boolean[] visited = new boolean[4];
        rotateCog.add(c);
        visited[c.cogN] = true;
        que.add(c);
        
        while(!que.isEmpty()) {
            Command cur = que.poll();

            int nextRotate = cur.roatate * -1;
            int left = cur.cogN - 1;

            if(left >= 0 && !visited[left]) {
                if(cog[cur.cogN][6] != cog[left][2]) {
                    visited[left] = true;
                    que.add(new Command(left, nextRotate));
                    rotateCog.add(new Command(left, nextRotate));
                } 
            }

            int right = cur.cogN + 1;
            if(right < 4 && !visited[right]) {
                if(cog[cur.cogN][2] != cog[right][6]) {
                    visited[right] = true;
                    que.add(new Command(right, nextRotate));
                    rotateCog.add(new Command(right, nextRotate));
                } 
            }
        }

        return rotateCog;
    }

}
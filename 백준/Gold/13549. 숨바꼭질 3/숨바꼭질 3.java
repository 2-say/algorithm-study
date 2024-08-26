import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static final int MAX = 100_001;
    static int[] dis;

    static class P {
        int val;
        int time;

        P(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX];
        dis = new int[MAX];
        Arrays.fill(dis, Integer.MAX_VALUE);
        bfs();
        System.out.println(dis[M]);
    }


    static void bfs() {
        Queue<P> que = new ArrayDeque<>();
        que.add(new P(N,0));
        visited[N] = true;

        while(!que.isEmpty()) {
            P cur = que.poll();

            //종료 조건 
            if(cur.val == M) {
                if(dis[cur.val] > cur.time) {
                    dis[cur.val] = cur.time;
                }
            }

            if(cur.val*2 < MAX && !visited[cur.val*2]) {
                visited[cur.val*2] = true;
                que.add(new P(cur.val*2, cur.time));
            }

            if(cur.val-1 >= 0 && !visited[cur.val-1]) {
                visited[cur.val-1] = true;
                que.add(new P(cur.val-1, cur.time + 1));
            }

            if(cur.val+1 < MAX &&  !visited[cur.val+1]) {
                visited[cur.val+1] = true;
                que.add(new P(cur.val+1, cur.time + 1));
            }

          

            
        }
    }
}
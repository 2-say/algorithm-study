import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static List<CCTV> cList;
    static int answer;

    static class P {
        int x;
        int y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class CCTV {
        int num;
        int x;
        int y;
        
        CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cList = new ArrayList();
        
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cList.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[8][4];
        dfs(0, new int[cList.size()]);
        System.out.println(answer);
    }

    static void dfs(int depth, int[] angles) {
        if(depth >= cList.size()) {
            int cnt = checkBlindSpot(angles);
            if(answer > cnt) answer = cnt;
        } else {
            for(int i = 0; i < 4; i++) {
                if(!visited[depth][i]) {
                    visited[depth][i] = true;
                    int[] temp = angles.clone();
                    temp[depth] = i; 
                    dfs(depth+1, temp);
                    visited[depth][i] = false;
                }
            }
        }
    }

    //결과 확인
    static int checkBlindSpot(int[] arr) {
        int[][] mapC = new int[N][M];

        for(int i = 0; i < N; i++) {
            mapC[i] = map[i].clone();
        }
        
        for(int i = 0; i < arr.length; i++) {
            CCTV c = cList.get(i);
            int angle = arr[i];
            

            if(c.num == 1) {
                if(angle == 0) drawOneLine(mapC, new P(c.x, c.y), 1);
                else if(angle == 1) drawOneLine(mapC, new P(c.x, c.y), 2);
                else if(angle == 2) drawOneLine(mapC, new P(c.x, c.y), 3);
                else if(angle == 3) drawOneLine(mapC, new P(c.x, c.y), 0);
            } else if(c.num == 2) {
                if(angle == 0 || angle == 2) {
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                } else if(angle == 1 || angle == 3) {
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                }
            } else if(c.num == 3) {
                if(angle == 0) {
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                } else if(angle == 1) {
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                } else if(angle == 2) {
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                } else if(angle ==3) {
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                }
            } else if(c.num == 4) {
                if(angle == 0) {
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                } else if(angle == 1) {
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                } else if(angle == 2) {
                    drawOneLine(mapC, new P(c.x, c.y), 1);
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                } else if(angle ==3) {
                    drawOneLine(mapC, new P(c.x, c.y), 3);
                    drawOneLine(mapC, new P(c.x, c.y), 0);
                    drawOneLine(mapC, new P(c.x, c.y), 2);
                }
            } else if(c.num == 5) {
                drawOneLine(mapC, new P(c.x, c.y), 0);
                drawOneLine(mapC, new P(c.x, c.y), 1);
                drawOneLine(mapC, new P(c.x, c.y), 2);
                drawOneLine(mapC, new P(c.x, c.y), 3);
            }
        }

        return countBlindSpot(mapC);
    }

    static void drawOneLine(int[][] mapC ,P start, int dir) {
        Queue<P> que = new ArrayDeque();
        que.add(start);

        while(!que.isEmpty()) {
            P cur = que.poll();

            if(cur.x < 0 || cur.y < 0 || cur.x >= N || cur.y >= M || mapC[cur.x][cur.y] == 6) break;

            if(mapC[cur.x][cur.y] == 0)
                mapC[cur.x][cur.y] = -1;

            if(dir == 0) que.add(new P(cur.x-1, cur.y));
            if(dir == 1) que.add(new P(cur.x, cur.y+1));
            if(dir == 2) que.add(new P(cur.x+1, cur.y));
            if(dir == 3) que.add(new P(cur.x, cur.y-1));
        }
    }

    static int countBlindSpot(int[][] mapC) {
        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         sb.append(mapC[i][j]).append(" ");
        //     }
        //     sb.append("\n");
        // }
        

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mapC[i][j]==0) count++;
            }
        }
        // sb.append("결과: " + count).append("\n");
        // System.out.println(sb);
        return count;
    }
}
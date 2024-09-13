import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] map = new long[N+1][N+1];
        
        int val = 0;
        for(int i = 1 ; i <= N; i++) {
            String[] in = br.readLine().split(" ");
            for(int j = 0; j <= N; j++) {
                if(j!=0) {
                    val += Integer.parseInt(in[j-1]);
                }
                map[i][j] = val;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            long ans = 0;
            for(int j = x1; j <= x2; j++) {
                ans += (map[j][y2] - map[j][y1-1]);
            }
            
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }


}
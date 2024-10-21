import java.io.*;
import java.util.*;

class Main {
    static int H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        for(int i = 0; i < H; i+= (N+1)) {
            for(int j = 0; j < W; j+= (M+1)) {
                answer++;
            }
        }
    
        System.out.println(answer);
    }

}
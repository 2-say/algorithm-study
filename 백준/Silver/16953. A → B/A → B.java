import java.io.*;
import java.util.*;

class Main {

    static int answer;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        answer = Integer.MAX_VALUE;
        dfs(A, 1);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    static void dfs(long val, int count) {
        if(val == B && answer > count) answer = count;

        if(val < B) {
            dfs(val * 10 + 1, count+1);
            dfs(val * 2, count+1);
        }
    }
}
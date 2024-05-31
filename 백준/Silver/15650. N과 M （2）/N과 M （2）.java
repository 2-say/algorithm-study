import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sb = new StringBuilder();

        solve(1,0);
        System.out.println(sb.toString());
    }

    public static void solve(int value, int depth) {
        //길이가 되면 출력하고 종료
        if(depth == M) {
            for(int i : arr) {
                if(i != 0)
                    sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = value; i <= N; i++) {
            //맨 앞을 채우고, 다음 칸(depth)으로 이동 value 이전값 + 1 
            arr[depth] = i;
            solve(i + 1, depth + 1);
        }
    }


}
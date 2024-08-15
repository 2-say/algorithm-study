import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] skewer;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[200_001];
        skewer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(move(0,0,0,0,0));
    }

    public static int move(int s, int e, int type, int max, int cnt) {
        if(e >= N) return max;

        if(num[skewer[e]] == 0) type++;
        cnt++;
        num[skewer[e]]++;
        
        //종류가 2가지 이상이면 오른쪽 증가
        if(type > 2) {
            --num[skewer[s]];
            if(num[skewer[s]]==0) type--;
            s++;
            cnt--;
        }

        max = Math.max(max,cnt);
        return move(s,e+1,type,max,cnt);
    }


}
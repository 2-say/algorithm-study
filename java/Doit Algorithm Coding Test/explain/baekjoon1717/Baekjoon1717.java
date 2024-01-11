import java.io.*;
import java.util.*;

public class Baekjoon1717 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        // 자기자신으로 초기화
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int fu = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (fu == 0)
                union(a, b);
            else {
                if (find(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
    static void union(int a, int b){
        int prentA = findPar(a);
        int prentB = findPar(b);
        if(prentA != prentB) arr[prentA] = prentB;
    }



    static boolean find(int a, int b) {
        if (findPar(a) == findPar(b)) {
            return true;
        } else
            return false;
    }

    static int findPar(int a) {
        if (arr[a] == a)
            return a;
        else {
            return arr[a] = findPar(arr[a]);
        }
    }
}
import java.io.*;
import java.util.*;

public class Baekjoon1991 {
    static int[][] binary;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        binary = new int[n][3]; // 중간 왼쪽 오른쪽
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] iput = br.readLine().split(" ");
            binary[iput[0].charAt(0) - 'A'][0] = iput[0].charAt(0) - 'A';
            binary[iput[0].charAt(0) - 'A'][1] = iput[1].charAt(0) - 'A';
            binary[iput[0].charAt(0) - 'A'][2] = iput[2].charAt(0) - 'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOder(0);
    }

    static void preOrder(int now) {
        if(now == -19){
            return;
        }
        System.out.printf("%c", binary[now][0] + 'A');
        preOrder(binary[now][1]);
        preOrder(binary[now][2]);
    }

    static void inOrder(int now) {
        if(now == -19){
            return;
        }
        inOrder(binary[now][1]);
        System.out.printf("%c", binary[now][0] + 'A');
        inOrder(binary[now][2]);
    }

    static void postOder(int now) {
        if(now == -19){
            return;
        }
        postOder(binary[now][1]); //왼쪽 쭉 파 
        postOder(binary[now][2]); //오른쪽 쭉 파
        System.out.printf("%c", binary[now][0] + 'A');
    }

}

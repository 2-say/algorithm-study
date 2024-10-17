import java.io.*;
import java.util.*;

class Main {

    static int[] players; 
    static boolean[] vals = new boolean[1_000_001];
    static int[] score = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        players = new int[n];

        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            vals[v] = true;
            players[i] = v;
        }

        for(int i = 0; i < n; i++) {
            int v = players[i];
            for(int j = v * 2; j < 1_000_001; j += v) {
                if(vals[j]) {
                    ++score[v];
                    --score[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int v = players[i];
            sb.append(score[v]).append(" ");
        }

        System.out.println(sb);
    }

}
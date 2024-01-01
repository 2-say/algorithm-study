import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon1033 {
    static ArrayList<Node>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];

    static class Node{
        int b;
        int p;
        int q;
        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
        public int getB() {
            return b;
        }
        public int getP() {
            return p;
        }
        public int getQ() {
            return q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];
        visited = new boolean[N];

        D = new long[N];
        lcm = 1;

        for(int i = 0 ; i < N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i =0; i< N-1; i++){
            int[] ar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = ar[0];
            int b = ar[1];
            int p = ar[2];
            int q = ar[3];
            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));
            lcm *=(p * q/ gcd(p,q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];

        for(int i = 1 ; i < N ; i++){
            mgcd = gcd(mgcd, D[i]);
        }

        for(int i = 0 ; i < N; i++){
            System.out.print(D[i]/mgcd + " ");
        }
    }

    static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }

    static void DFS(int node){
        visited[node] = true;
        for(Node i : A[node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    
}

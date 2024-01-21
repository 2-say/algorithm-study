import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Beakjoon11404 {

    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = 10000001;
            }
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            //중복 간선처리 (비용이 더작은 걸로 입력)
            if(dist[s][e] > cost) dist[s][e] = cost; 
        }



        floyd(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 10000001)
                    System.out.print("0 ");
                else
                    System.out.printf("%d ", dist[i][j]);
            }
            System.out.println();
        }

    }

    static void floyd(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue; 
                for (int j = 0; j < n; j++) {
                    if (j == i || j == k) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

}

import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static boolean[] visited;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    visited = new boolean[N];

    dfs(0);
  }


  static void dfs(int depth) {
    if(depth == M) {
      for(int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
      return;
    }
    
    for(int i = 0; i < N; i++) {
      if(!visited[i]) {
        visited[i] = true;

        arr[depth] = i+1;
        dfs(depth+1);

        visited[i] = false;
      }
    }
  }
}
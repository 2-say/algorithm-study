import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Baekjoon1260 {
    static ArrayList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(input[0]);
        int edgeNum = Integer.parseInt(input[1]);
        int startNode = Integer.parseInt(input[2]);
        visited = new boolean[nodeNum+1];
        list = new ArrayList[nodeNum+1];

        for(int i = 0; i < nodeNum+1 ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edgeNum; i++){
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 0 ; i <=nodeNum; i++){
            Collections.sort(list[i]);
        }

        dfs(startNode);
        System.out.println();
        visited = new boolean[nodeNum+1]; 
        bfs(startNode);
    }

    static void bfs(int startNode) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(startNode);
        visited[startNode] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            System.out.printf("%d ",node);
            for(int i : list[node])
            {
                if(!visited[i]){
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
    
    static void dfs(int startNode) {
        System.out.printf("%d ",startNode);
        visited[startNode] = true;
        for(int i : list[startNode]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}

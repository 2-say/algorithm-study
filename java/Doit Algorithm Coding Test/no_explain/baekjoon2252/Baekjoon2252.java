import java.util.*;
import java.io.*;

public class Baekjoon2252 {
    static List<Integer>[] list;
    static int[] inOut;
    static int[] inOut_tmp;
    static boolean[] visited;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        res = new ArrayList<>();
        list = new List[n+1];
        visited = new boolean[n+1];
        inOut = new int[n+1];
        inOut_tmp = new int[n+1];

        for(int i = 0 ; i < n +1 ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            list[s].add(en);
            inOut_tmp[en]++;
        }
        // System.out.println(Arrays.toString(inOut_tmp));
        inOut = inOut_tmp.clone();
        
        for(int i = 1 ; i < inOut.length; i++){
            if(inOut[i] == 0 && !visited[i]) 
            {
                topoSort(i);
            }
        }

        for (int i : res) {
            System.out.printf("%d ",i);
        }

    }

    static void topoSort(int s) {
        Queue<Integer> que = new ArrayDeque<>();
        visited[s] = true;
        que.add(s);

        while(!que.isEmpty()){
            int cur = que.poll();
            res.add(cur);
            for (Integer next : list[cur]) {
                inOut[next]--;
                if(inOut[next] == 0 && !visited[next]){
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}

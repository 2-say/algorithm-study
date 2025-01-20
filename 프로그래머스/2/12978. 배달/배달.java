import java.util.*;


class Solution {
    static int[] dis;
    static int MAX_VALUE = 999_999;
    static List<V>[] nList;
    
    static class V {
        int e;
        int cost;
        V(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        nList = new List[N+1];
        for(int i = 0; i < N+1; i++) {
            nList[i] = new ArrayList<>();
        }
        dis = new int[N+1];
        
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            nList[a].add(new V(b, cost));
            nList[b].add(new V(a, cost));
        }
        
        
        Arrays.fill(dis, MAX_VALUE);
        
        dijkstra(road);
        
        for(int i = 0; i < N+1; i++) {
            if(dis[i] <= K) answer++;
        }

        return answer;
    }
    
    
    void dijkstra(int[][] road) {
        dis[1] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(V v : nList[cur]) {
                if(dis[v.e] > dis[cur] + v.cost) {
                    dis[v.e] = dis[cur] + v.cost;
                    q.add(v.e);
                }
            }
        }
        
        return;
    }
}
import java.util.*;

class Solution {
    static List<Integer>[] nList;
    static int[] dp;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
    
    public List solution(int n, int[][] roads, int[] sources, int destination) {
        nList = new List[n+1];
        dp = new int[n+1];
        
        // 거리 설정
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // 초기화
        for(int i = 0; i <= n; i++) nList[i] = new ArrayList<>();
        
        // 그래프 초기화
        for(int[] r : roads) {
            int s = r[0];
            int e = r[1];
            // 무방향 그래프
            nList[s].add(e);
            nList[e].add(s);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        dp[destination] = 0;
        dijkstra(roads, destination);
        
        for(int st : sources) {
            if(dp[st] == Integer.MAX_VALUE) answer.add(-1);
            else answer.add(dp[st]);
        }
        
        return answer;
    }
    
    public static void dijkstra(int[][] roads, int s) {
        pq.add(new int[]{s, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            for(int n : nList[cur[0]]) {
                if(dp[n] > dp[cur[0]] + 1) {
                    dp[n] = dp[cur[0]] + 1;
                    pq.add(new int[]{n, dp[n]});
                }
            }
        }
        
    }
}
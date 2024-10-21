//프림, 크루스칼 알고리즘
import java.util.*;

class Solution {
    
    static int[] union;
    static Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.cost, o2.cost);
        });
    
    static class Edge {
        int s, e, cost;
        Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        union = new int[n];
        
        for(int i = 0; i < n; i++) union[i] = i;
        for(int i = 0; i < costs.length; i++) {
            int s = costs[i][0];
            int e = costs[i][1];
            int c = costs[i][2];
            pq.add(new Edge(s,e,c));
        }
        
        int select = 0; //선택한 간선
        while(!pq.isEmpty() && select < n-1) { //n-1개 선택
            Edge eg = pq.poll();
            if(find(eg.s) != find(eg.e)) {
                union(eg.s, eg.e);
                select++;
                answer += eg.cost;
            }
        }
        return answer;
    }
    
    static int find(int cur) {
        if(cur == union[cur]) return cur;
        else return union[cur] = find(union[cur]);
    }
    
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) union[pa] = pb;
    }
}
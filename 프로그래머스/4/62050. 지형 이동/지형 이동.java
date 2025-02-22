import java.util.*;

class Solution {
    
    private static class Node {
        int i, j, cost;
        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(visited[now.i][now.j]) continue;
            
            visited[now.i][now.j] = true;
            answer += now.cost;
            
            for(int i = 0; i < 4; i++) {
                int ny = now.i + dy[i];
                int nx = now.j + dx[i];
                
                if(!(0 <= ny && ny < n && 0 <= nx && nx < n)) continue;
                
                int tmpCost = Math.abs(land[now.i][now.j] - land[ny][nx]);
                int newCost = tmpCost > height ? tmpCost : 0;
                pq.add(new Node(ny, nx, newCost));
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    static List<Integer>[] nList;
    static int answer;
    
    static class Node {
        int node, sheep, wolf;
        HashSet<Integer> visited;
        
        Node(int node, int sheep, int wolf,  HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        nList = new List[info.length]; 
        for(int i = 0; i < info.length; i++) nList[i] = new ArrayList<>();
        
        for(int[] e : edges) {
            int s = e[0];
            int end = e[1];
            nList[s].add(end);
        }
        
        bfs(info);
        return answer;
    }
    
    public static void bfs(int[] info) {
        HashSet<Integer> hs = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 1, 0, hs));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            answer = Math.max(answer, cur.sheep);
            cur.visited.addAll(nList[cur.node]);
            
            for(Integer next : cur.visited) { //자식노드 순회
                HashSet<Integer> newSet = new HashSet<>(cur.visited); //여기서 다시 방문할 수 있도록 모두 넣음
                newSet.remove(next); //방문 처리
                
                if(info[next] == 0) {
                    q.add(new Node(next, cur.sheep + 1, cur.wolf, newSet));
                } else {
                    if(cur.sheep <= cur.wolf + 1) continue; //갈 수 없다면 패스
                    q.add(new Node(next, cur.sheep, cur.wolf + 1, newSet));
                }
            }
        }
    }
}
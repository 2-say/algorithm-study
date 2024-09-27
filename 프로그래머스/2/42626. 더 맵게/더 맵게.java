import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();        
        for(int v : scoville) que.add(v);
   
        int val;
        while((val = que.poll()) < K) {
            int two;
            if(que.isEmpty() || (two = que.poll()) == 0) return -1;
                
            que.add(val + (two*2));
            answer++;
        }
        
        return answer;
    }
}
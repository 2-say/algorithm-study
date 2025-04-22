import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean isTrue = true;
        long pulse1 = 0;
        long pulse2 = 0;
        
        for(int num : sequence) {
            pulse1 += isTrue ? -num : num;
            pulse2 += isTrue ? num : -num;
            
            pulse1 = Math.max(pulse1, 0);
            pulse2 = Math.max(pulse2, 0);
            
            answer = Math.max(answer, Math.max(pulse1, pulse2));
            
            isTrue = !isTrue;
        }
        
        return answer;
    }
}
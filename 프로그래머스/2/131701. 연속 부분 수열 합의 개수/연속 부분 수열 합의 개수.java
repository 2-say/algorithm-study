import java.util.*;

class Solution {
    static int[] sum;
    static Set<Integer> answer = new HashSet<>();
    
    public int solution(int[] elements) {
        sum = new int[elements.length * 2];
        int idx = 0;
        
        for(int i : elements) {
            sum[idx++] = i;
        }
        
        for(int i : elements) {
            sum[idx++] = i;
        }
        
        for(int len = 1; len <= elements.length; len++) {
            for(int i = 0; i < elements.length; i++) {
                int value = 0;
                for(int j = i; j < i + len; j++) value += sum[j];
                answer.add(value);
            }
        }
        
        return answer.size();
    }
}
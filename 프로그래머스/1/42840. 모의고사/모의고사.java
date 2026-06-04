import java.util.*;

class Solution {
    int[] N1 = {1,2,3,4,5};
    int[] N2 = {2,1,2,3,2,4,2,5};
    int[] N3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int i1 = 0, i2 = 0, i3 = 0;
        int a1 = 0, a2 = 0, a3 = 0; 
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == N1[i1++]) a1++;
            if(answers[i] == N2[i2++]) a2++;
            if(answers[i] == N3[i3++]) a3++;
            i1 %= N1.length;
            i2 %= N2.length;
            i3 %= N3.length;
        }
        
        List<Integer> result = new ArrayList<>();
        int maxAnswerCount = 0;
        maxAnswerCount = Math.max(a1, Math.max(a2, a3));
        
        if(a1 == maxAnswerCount) result.add(1); 
        if(a2 == maxAnswerCount) result.add(2); 
        if(a3 == maxAnswerCount) result.add(3); 
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;

class Solution {
    public List solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        
        int a1 = 0, a2 = 0, a3 = 0;
        int c1 = 0, c2 = 0, c3 = 0;
        for(int n : answers) {
            if(a1 >= num1.length) a1 = (a1 % num1.length);
            if(a2 >= num2.length) a2 = (a2 % num2.length);
            if(a3 >= num3.length) a3 = (a3 % num3.length);
            
            if(num1[a1] == n) c1++;
            if(num2[a2] == n) c2++;
            if(num3[a3] == n) c3++;
            
            a1++;
            a2++;
            a3++;
        }
        
        int result = Math.max(c1, Math.max(c2, c3));
        
        
        if(result == c1) answer.add(1);
        if(result == c2) answer.add(2);
        if(result == c3) answer.add(3);
        
        return answer;
    }
}
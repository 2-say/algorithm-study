import java.util.*;

class Solution {
    public List solution(String s) {
        List<Integer> answer = new ArrayList<>();
        answer.add(-1);
        
        for(int i = 1 ; i < s.length(); i++) {
            int which = -1;
            for (int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    which = i-j;
                }
            }
            answer.add(which);
        }
        return answer;
    }
}
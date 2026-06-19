import java.util.*;

class Solution {
    String S;
    char[] SPT;
    
    public int solution(String s) {
        S = s;
        SPT = S.toCharArray();
        
        int answer = 0;
        for(int i = 0; i < S.length(); i++) {
            if(checkRightString(i)) answer++;
        }
        
        return answer;
    }
    
    public boolean checkRightString(int startIdx) {
        Stack<Character> stac = new Stack();
        
        for(int i = startIdx; i < S.length() + startIdx; i++) {
            int idx = i % S.length();
            
            if(SPT[idx] == '(' || SPT[idx] == '{' || SPT[idx] == '[') {
                stac.add(SPT[idx]);
            } else {
                if(stac.isEmpty()) return false;
                char popChar = stac.pop();
                if(SPT[idx] == ')' && '(' != popChar) return false;
                if(SPT[idx] == '}' && '{' != popChar) return false;
                if(SPT[idx] == ']' && '[' != popChar) return false;
            }
        }
        
        if(stac.isEmpty()) return true;
        return false;
    }
}
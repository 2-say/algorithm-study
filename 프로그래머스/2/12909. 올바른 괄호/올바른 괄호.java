import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stac = new Stack();
        for(char par : s.toCharArray()) {
            if(par == '(') stac.add(par);
            else {
                if(stac.isEmpty()) return false;
                stac.pop();
            }
        }
        
        if(stac.isEmpty()) return true;
        return false;
    }
}
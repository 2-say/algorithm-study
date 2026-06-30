import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    
    public String solution(String s) {
        s = s.toLowerCase();
        char[] schar = s.toCharArray();
        
        boolean isPrevWord = true;
        for(int i = 0; i < schar.length; i++) {
            char c = schar[i];
            
            if(isPrevWord && c >= 97 && c <= 122) {
                schar[i] -= 32;
                isPrevWord = false;
            }
            
            else if(c == ' ') isPrevWord = true;
            else isPrevWord = false;
        }
        
        return new String(schar);
    }
}
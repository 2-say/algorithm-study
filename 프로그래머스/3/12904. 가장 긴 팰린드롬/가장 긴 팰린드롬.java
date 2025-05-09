import java.util.*;

class Solution {
    String S;
    public int solution(String s) {
        S = s;
        for(int len = s.length(); len >= 2; len--) {
            for(int i = 0; i <= s.length() - len; i++) {
                int res = isCount(i, i + len, len);
                if(res != -1) {
                   return res;
                }
            }
        }
        
        return 1;
    }
    
    public int isCount(int s, int e, int len) {
        e--;
        boolean isPalind = true;
        
        while(s < e) {
            if(S.charAt(s) != S.charAt(e)) {
                isPalind = false;
                break;
            }
            s++;
            e--;
        }
        
        return (isPalind) ? len : -1;
    }
}
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stac = new Stack();
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(arr[i] == '(') {
                stac.add(arr[i]);
            } else {
                if(stac.isEmpty()) return false;
                while(stac.pop() != '(') {}
            }
        }
        
        if(stac.isEmpty()) return true;
        else return false;
    }
}
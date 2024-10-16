import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int[] alpha = new int[140]; //abcdefghijklmopqrstuvwxyz
        Stack<Character> stac = new Stack<>();
        char[] cArr = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            if(!stac.isEmpty() && stac.peek() == cArr[i]) {
                stac.pop();
            } else {
                stac.add(cArr[i]);
            }
        }
        
        if(!stac.isEmpty()) return 0;
        return 1;
    }
}
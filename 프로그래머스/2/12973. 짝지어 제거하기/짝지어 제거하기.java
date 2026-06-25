import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stac = new Stack();
        char[] cs = s.toCharArray();
        for(char c : cs) {
            
            if(!stac.isEmpty() && c == stac.peek()) {
                stac.pop();
            } else {
                stac.add(c);
            }
        }
        
        if(stac.isEmpty()) return 1;
        return 0;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int[] s : sizes) {
            Arrays.sort(s);
        }
        
        int max1 = 0;
        int max2 = 0;
        
        for(int[] s: sizes) {
            if(max1 <= s[0]) max1 = s[0];
            if(max2 <= s[1]) max2 = s[1];
        }
        
        return max1 * max2;
    }
}
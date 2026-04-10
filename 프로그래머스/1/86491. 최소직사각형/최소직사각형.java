import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int mW = 0, mH = 0;
        for(int[] s : sizes) Arrays.sort(s);
        for(int[] s : sizes) {
            mW = Math.max(mW, s[0]);
            mH = Math.max(mH, s[1]);
        }
        
        return mW * mH ;
    }
}
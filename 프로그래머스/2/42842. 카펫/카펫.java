import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int w=-1, h=-1;
        boolean end = false;
        
        for(int i = 2; i <= brown + yellow; i++) {
            for(int j = 2; i * j <= brown + yellow; j++) {
                if(i * j == brown + yellow && (i*2)+(j-2)*2 == brown) {
                    end = true;
                    w = Math.max(i,j);
                    h = Math.min(i,j);
                    break;
                }
            }
            
            if(end) break;
        }
        
        return new int[]{w,h};
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prv = 1;
        
        for(int s : stations) {
            if((s-(w)) <= prv) {
                prv = s + w + 1;
                continue;
            }
            
            long range = (s - w) - prv;
            double result = (double)range / ((w * 2) + 1);
            answer += Math.ceil(result);
            prv = s + w + 1;
        }
        
        if(n >= prv) {
            long range = (n + 1) - prv;
            double result = (double)range / ((w * 2) + 1);
            answer += Math.ceil(result);
        }
        
        return answer;
    }
}
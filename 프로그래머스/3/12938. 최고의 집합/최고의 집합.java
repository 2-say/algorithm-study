import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        int m = s / n;
        int l = s % n;
        for(int i = 0; i < n; i++) {
            if(n - i <= l) answer[i] = m+1;
            else answer[i] = m;
        }
        
        return answer;
    }
}
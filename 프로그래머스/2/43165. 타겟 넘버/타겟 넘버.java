import java.util.*;

class Solution {
    int answer;
    int[] N;
    int T;
    
    public int solution(int[] numbers, int target) {
        N = numbers;
        T = target;
        dfs(0, 0); 
        
        return answer;
    }
    
    public void dfs(int val, int idx) {
        if(idx == N.length) {
            if(val == T) {
                answer++;
            }
            return;
        }
        
        dfs(val + N[idx], idx + 1);
        dfs(val - N[idx], idx + 1);
    }
}
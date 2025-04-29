import java.util.*;

class Solution {
    static String[] sWords;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        sWords = words;
        
        for(int i = 0; i < words.length; i++) {
            visited = new boolean[words.length];
            if(isPossibleWord(begin, i)) {
                visited[i] = true;
                dfs(i, 0, target);
                visited[i] = false;
            }
        }
        
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    public void dfs(int idx, int count, String t) {
        if(t.equals(sWords[idx])) {
            answer = Math.min(answer, count + 1);
            return;
        }
        
        for(int i = 0; i < sWords.length; i++) {
            if(idx == i) continue;
            
            if(isPossibleWord(sWords[i], idx) && !visited[i]) {
                visited[i] = true;
                dfs(i, count + 1, t);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPossibleWord(String base, int idx) {
        int count = 0;
        char[] targetC = sWords[idx].toCharArray();
        char[] baseC =  base.toCharArray();
        
        for(int i = 0; i < targetC.length; i++) {
            if(targetC[i] != baseC[i]) count++;
        }
        
        return (count == 1) ? true : false;
    }
}
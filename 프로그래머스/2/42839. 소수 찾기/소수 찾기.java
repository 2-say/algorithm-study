import java.util.*;

class Solution {
    static boolean[] visited;
    static int len;
    static int answer;
    static Set<Integer> primeSet;
    
    public int solution(String numbers) {
        primeSet = new HashSet<>();
        answer = 0;
        len = numbers.length();
        visited = new boolean[len];
        
        //자리수 선택
        for(int i = 0; i < len; i++) {
            dfs(0, i+1, "", numbers);
        }
        
        return primeSet.size();
    }
    
    
    static void dfs(int depth, int range, String now, String numbers) {
        if(depth == range) {
            if(isPrime(Integer.parseInt(now))) primeSet.add(Integer.parseInt(now));
            return;
        }
        
        for(int i = 0; i < len; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(depth + 1, range ,now + numbers.charAt(i), numbers);
            visited[i] = false; 
        }
        
        return;
    }
    
    static boolean isPrime(int n) {
        if(n == 1 || n == 0) return false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
            
        return true;    
    }
}

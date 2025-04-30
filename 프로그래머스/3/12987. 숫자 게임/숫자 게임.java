import java.util.*;

class Solution {
    static int answer = 0;
    static List<Integer> lst = new ArrayList<>();
    
    public int solution(int[] A, int[] B) {
        for(int v : B) lst.add(v);
        Collections.sort(lst);
        
        boolean[] v = new boolean[A.length];
        for(int i = 0; i < A.length; i++) {
            int idx = binarySearch(0, lst.size() - 1, A[i]);
            
            if(A[i] < lst.get(idx)) {
                lst.remove(idx);
                answer++;
            }
        }
         
        return answer;
    }
     
    // upper bound binary search
    public int binarySearch(int s, int e, int target) {
        while(s < e) {
            int mid = (s + e) / 2;
            if(target >= lst.get(mid)) s = mid + 1;
            else e = mid; 
        }
        
        return e;
    }
}
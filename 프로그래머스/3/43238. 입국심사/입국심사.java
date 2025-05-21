import java.util.*;
class Solution {
    static int[] T;
    static long answer;
    
    public long solution(int n, int[] times) {
        T = times;
        Arrays.sort(T);
        
        binarySearch(n);
        return answer;
    }
    
    
    public void binarySearch(int n) {
        long s = 0, e = T[T.length - 1] * (long)n;

        while(s <= e) {
            long mid = (s + e) / 2;
            
            if(n > cal(mid)) s = mid + 1;
            else {
                answer = mid;
                e = mid - 1; 
            }
        }
    }
    
    // 시간 값이 크다면 int 형을 넘길 수 있음
    public long cal(long mid) {
        long count = 0;
        for(int t : T) count += (mid/t);
        return count;
    }
}
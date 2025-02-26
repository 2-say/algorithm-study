import java.util.*;

class Solution {
    static int answer = 99_999_999;
    static int[] D;
    static int[] T;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Arrays.stream(diffs).max().getAsInt();
        D = diffs;
        T = times;
        
        binarySearch(max, limit);
        
        return answer;
    }
    
    public void binarySearch(int max, long limit) {
        int s = 1;
        int e = max;
        
        while(s <= e) {
            int mid = (s + e) / 2;
            int tmp;
            //체크 적당한 레벨이 맞는지
            if(limit < check(mid)) {
                s = mid + 1;
            } else if(limit >= check(mid)) {
                e = mid - 1;
                answer = Math.min(answer, mid);
            }
            
        }
    }
    
    public long check(int level) { // 소요 시간 체크
        long time = T[0];
        
        for(int i = 1; i < D.length; i++) {
            if(D[i] <= level) { //레벨이 더 높으면 패스
                time += T[i];
                continue;
            } else { 
                long tmp = T[i-1] + T[i];
                long n = D[i] - level; //횟수
                time += (tmp * n + T[i]);
            }
        }
        
        return time;
    }
}
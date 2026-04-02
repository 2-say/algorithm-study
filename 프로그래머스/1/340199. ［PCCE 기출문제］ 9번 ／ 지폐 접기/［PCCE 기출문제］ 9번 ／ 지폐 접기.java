import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(bill);
        Arrays.sort(wallet);
        
        // 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접는다.
        
        while(true) {
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            }
            
            // 반을 접는다.
            bill[1] = (bill[1] / 2);
            Arrays.sort(bill);
            answer++;
        }
        
        return answer;
    }
}
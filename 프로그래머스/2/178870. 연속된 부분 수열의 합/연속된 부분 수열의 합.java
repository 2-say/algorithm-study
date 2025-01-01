import java.util.*;

class Solution {
    static int[] sumArr;
    
    public int[] solution(int[] sequence, int k) {
        sumArr = new int[sequence.length+1]; //누적합 배열
        int CSUM = 0;
        for(int i = 0; i < sequence.length; i++) {
            CSUM += sequence[i];
            sumArr[i+1] = CSUM;
        }
        
        return binaryFind(sequence, k);
    }
    
    public int[] binaryFind(int[] sequence, int k) {
        int sIdx = 1, eIdx = 1;
        int[] answer = new int[2];
        answer[1] = sequence.length - 1;
        answer[0] = 0;
        
        while(eIdx <= sequence.length && sIdx <= sequence.length) {
            int sum = sumArr[eIdx] - sumArr[sIdx-1];
            
            if(k > sum) {
                eIdx++;
            } else if(k < sum) {
                sIdx++;
            } else { //같을 때
                if((answer[1] - answer[0]) > eIdx-sIdx) { //정답 기록
                    answer[1] = eIdx-1;
                    answer[0] = sIdx-1;
                }
                eIdx++;
            }
        }
        
        return answer;
    }
}
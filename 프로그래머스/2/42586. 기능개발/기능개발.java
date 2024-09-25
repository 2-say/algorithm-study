import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        Queue<Integer> que = new ArrayDeque<>();
        for(int i : progresses) que.add(i);
        
        int idx = 0;
        int answerIdx = -1;
        int maxDay = 0;
        while(!que.isEmpty()) {
            int prog = que.poll();
            int day = 0;
            if((100 - prog) % speeds[idx] != 0) day = ((100 - prog) / speeds[idx]) + 1;
            else day = ((100 - prog) / speeds[idx]);
            
            if(maxDay < day) {
                maxDay = day;
                answer[++answerIdx]++;
            } else answer[answerIdx]++;
            idx++;
        }
        
        
        
        int c = 0;
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) {
                break;  
            } else {
                c++;
            }
        }
        
        int[] tmp = new int[c];
        for(int i = 0; i < c; i++) {
            tmp[i] = answer[i];
        }
        
        return tmp;
    }
}
import java.util.*;

class Solution {
    static int N;
    static int[] INFO;
    static int maxS;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        maxS = 0;
        N = n;
        INFO = info;
        
        dfs(new int[11], n, 0);
        
        
        if(answer == null) return new int[]{-1};
        return answer;
    }
    
    
    public void dfs(int[] score, int lC, int i) {
        if(i ==11 || lC == 0) {
            score[10] += lC; // 남은 화살을 0점에 배치
            int rs = calScore(score);
            if (rs > maxS) { // 점수 차이가 최대인 경우
                maxS = rs;
                answer = score.clone();
            } else if (rs == maxS) { // 점수 차이가 같은 경우
                if(answer == null) return;
                if (isBetter(score)) answer = score.clone();
            }
            
            return;
        }
        
        //화살 충분하면 피치 이길 정도로 화살 감소
        if(lC > INFO[i]) {
            score[i] = INFO[i] + 1;
            dfs(score.clone(), lC - score[i], i+1);
            score[i] = 0;
        }
        
        //다음으로 넘기기
        dfs(score, lC, i+1);
    }
    
    public int calScore(int[] l) {
        int lScore = 0;
        int aScore = 0;
        for(int i = 0; i <= 10; i++) {
            if(INFO[i] == 0 && l[i] == 0) continue;
            if(INFO[i] < l[i]) lScore += (10-i);
            else aScore += (10-i);
        }
        
        return lScore - aScore;
    }
    
     public boolean isBetter(int[] score) {
        for (int i = 10; i >= 0; i--) {
            if (score[i] > answer[i]) return true; 
            if (score[i] < answer[i]) return false; 
        }
        return false;
    }
}
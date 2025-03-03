
class Solution {
    static int[][] table = new int[][]{{1,1,1}, {5, 1, 1} , {25, 5, 1}};
    static int N;
    static String[] M;
    static int answer = 99_999_999;
    
    public int solution(int[] picks, String[] minerals) {
        N = minerals.length;
        M = minerals;
        dfs(picks, 0, 0);
        return answer;
    }
    
    public void dfs(int[] picks, int score, int idx) {
        boolean isEnd = true;
        for(int i = 0; i < 3; i++) if(picks[i] > 0) isEnd = false;
        if(isEnd || idx >= N) {
            answer = Math.min(answer, score);
            return;
        }
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] != 0) {
                int tmp = score;
                for(int j = idx; j < Math.min((idx+5), N); j++) { //5번 진행
                    if(M[j].equals("diamond")) {
                        tmp += table[i][0];
                    } else if(M[j].equals("iron")) {
                        tmp += table[i][1];
                    } else {
                        tmp += table[i][2];
                    }
                }
                
                //해당 방법 선택
                int[] copy = picks.clone();
                copy[i]--;
                
                dfs(copy, tmp, Math.min((idx+5), N));
            }
        }
        
        
    }
}
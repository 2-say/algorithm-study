class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int idx = 0;
        int[] answer = new int[targets.length];
        
        int score = 0;
        
        
        for(String a : targets) {
            for(String b : a.split("")) {
                //A B C D 
                boolean isFound = false;
                int temp = Integer.MAX_VALUE;
                
                for(String s : keymap) {
                    if (s.indexOf(b) != -1 && temp > s.indexOf(b) + 1) {
                        isFound = true;
                        temp = s.indexOf(b) + 1;
                    }
                }
    
                if(isFound) {
                    score += temp; 
                } else {
                    answer[idx] = -1;
                    break;
                }
            }
            
            if(answer[idx] != -1) 
                answer[idx] = score;
            idx++;
            score = 0;
        }
        
        return answer;
    }
}
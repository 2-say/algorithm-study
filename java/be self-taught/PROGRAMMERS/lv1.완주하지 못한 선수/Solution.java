import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> finish = new HashMap();
        
        for(String s : participant) {
            if(finish.containsKey(s)) {
                finish.put(s, finish.get(s) + 1);
            } else {
                finish.put(s, 1);
            } 
        }
        
        for(String s : completion) {
            finish.put(s, finish.get(s) - 1);
        }
        
        for(Map.Entry<String, Integer> e : finish.entrySet()) {
            if(e.getValue() > 0) {
                return e.getKey();
            }
        }
        
        return answer;
    }
}
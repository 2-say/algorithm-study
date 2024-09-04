import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> type = new HashMap<>();
        for(String[] c : clothes) {
            if(!type.containsKey(c[1])) type.put(c[1], 1);
            else type.put(c[1], type.get(c[1]) + 1);
        }
        
        
        for(Integer i : type.values())
            answer *= (i + 1);
        
        return answer-1;
    }
}
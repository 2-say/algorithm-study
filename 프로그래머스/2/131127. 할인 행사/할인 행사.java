import java.util.*;

class Solution {
    static Map<String, Integer> dMap = new HashMap<>(); //item count save 
    static Map<String, Integer> wMap = new HashMap<>(); //item index save
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < want.length; i++) wMap.put(want[i], i); // init keyword save
        
        for(int i = 0; i < 10; i++) {
            if(wMap.containsKey(discount[i])) { //around wants
                if(dMap.containsKey(discount[i])) dMap.put(discount[i], dMap.get(discount[i]) + 1);
                else dMap.put(discount[i], 1);
            }
        }
        
        if(check(want, number)) answer++; //answer check
        
        if(discount.length > 10) {
            int s = 0;
            for(int i = 10; i < discount.length; i++) {
                if(dMap.containsKey(discount[s])) dMap.put(discount[s], dMap.get(discount[s]) - 1);
                s++;

                if(wMap.containsKey(discount[i])) { //원하는 품목
                    if(dMap.containsKey(discount[i])) {
                        dMap.put(discount[i], dMap.get(discount[i]) + 1);
                    } else {
                        dMap.put(discount[i], 1);
                    }
                }
                
                if(check(want, number)) answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(String[] want, int[] number) {
        for(String s : want) {
            int idx = wMap.get(s);
            if(!dMap.containsKey(s) || dMap.get(s) < number[idx]) return false;
        }
        return true;
    }
}
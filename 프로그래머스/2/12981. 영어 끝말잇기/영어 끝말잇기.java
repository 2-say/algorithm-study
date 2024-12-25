import java.util.*;

class Solution {
    Map<String, Integer> word = new HashMap<>();
    Map<Integer, Integer> whoSay = new HashMap<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        whoSay.put(0, 1);
        word.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++) {
            int idx = i % n;
            char[] cur = words[i].toCharArray();
            char lastC = cur[0];
            char[] prev = words[i-1].toCharArray();
            char lastP = prev[prev.length-1];
            
            if(word.containsKey(words[i]) || (lastP != lastC)) {
                answer[0] = idx + 1;
                answer[1] = whoSay.getOrDefault(idx, 0) + 1;
                break;
            } else {
                word.put(words[i], 1);
                whoSay.put(idx, whoSay.getOrDefault(idx, 0) + 1);
            }
        }
        return answer;
    }
}
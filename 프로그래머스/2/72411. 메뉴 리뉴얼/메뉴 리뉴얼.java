import java.util.*;

class Solution {
    static Map<Integer, Map<String, Integer>> csMap = new HashMap<>();
    static List<String> answer = new ArrayList<>();

    public List<String> solution(String[] orders, int[] course) {
        for(int c : course) csMap.put(c, new HashMap<>());
        
        for(String o : orders) {
            char[] cArr = o.toCharArray();
            Arrays.sort(cArr);
            combination(cArr, "", 0);
        }
        
        for(Map<String, Integer> cs : csMap.values()) {
            int maxValue = Integer.MIN_VALUE;
            for (int value : cs.values()) {
                maxValue = Math.max(maxValue, value);
            }
            
            for (Map.Entry<String, Integer> ent : cs.entrySet()) {
                if(maxValue == ent.getValue() && maxValue >= 2) {
                    answer.add(ent.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    
    static void combination(char[] o, String cur, int idx) {
        if(csMap.containsKey(cur.length())) {
            Map<String, Integer> cM = csMap.get(cur.length());
            cM.put(cur, cM.getOrDefault(cur, 0) + 1);
        }
        
        for(int i = idx; i < o.length; i++) {
            combination(o, cur + o[i], i+1);
        }
    }
}
import java.util.*;

class Solution {
    static PriorityQueue<Tuple> pq = new PriorityQueue<>();
    
    static class Tuple implements Comparable<Tuple> {
        Map<String, Integer> map;    
        
        public Tuple() {
            this.map = new HashMap<>();
        }
        
        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(this.map.size(), o.map.size());
        }
    }
    
    
    public List<Integer> solution(String s) {
        char[] cs = s.toCharArray();
        
        Tuple t = null;
        StringBuilder sb = null;   
        for(int i = 1; i < s.length(); i++) {
            if(cs[i] == '{') {
                sb = new StringBuilder();
                t = new Tuple();
            } else if(cs[i] == '}') {
                t.map.put(sb.toString(), t.map.getOrDefault(sb.toString(), 0) + 1);
                pq.add(t);
                i++;
            } else if(cs[i] == ',') {
                t.map.put(sb.toString(), t.map.getOrDefault(sb.toString(), 0) + 1);
                sb = new StringBuilder();
            } else {
                sb.append(cs[i]);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        Tuple t1 = pq.poll();
        for(String key : t1.map.keySet()) answer.add(Integer.parseInt(key));
        
        while(!pq.isEmpty()) {
            Tuple t2 = pq.poll();
                
            for(String key : t1.map.keySet()) {
                t2.map.put(key, t2.map.get(key) - 1);
            }
            
            for(String key : t2.map.keySet()) {
                if(t2.map.get(key) > 0) {
                    answer.add(Integer.parseInt(key));
                }
            }
            
            t1 = t2;
        }
        
        return answer;
    }
}
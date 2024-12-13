import java.util.*;

class Solution {
    boolean[][] visited;
    static List<Integer>[] nList;
    static Map<String, Integer> idMap = new HashMap<>();
    static Map<String, Integer> reportCount = new HashMap<>();
    
    public List<Integer> solution(String[] id_list, String[] report, int k) {
        nList = new List[id_list.length];
        visited = new boolean[id_list.length][id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            nList[i] = new ArrayList<>();
            idMap.put(id_list[i], i);
        }
        
        for(String r : report) {
            String[] rs = r.split(" ");
            String reporter = rs[0];
            int reporterID = idMap.get(reporter);
            String reported = rs[1];
            int reportedID = idMap.get(reported);
            
            if(!visited[reporterID][reportedID]) {
                visited[reporterID][reportedID] = true;
                nList[reporterID].add(reportedID);
                
                if(reportCount.containsKey(reported)) {
                    reportCount.put(reported, reportCount.get(reported) + 1);
                } else {
                    reportCount.put(reported, 1);
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(List<Integer> reporterL : nList) {
            int count = 0;
            for(int reportedL : reporterL) {
                String name = id_list[reportedL];
                
                if(reportCount.containsKey(name) && reportCount.get(name) >= k) {
                    count++;
                }
            }
            answer.add(count);
        }
        
        return answer;
    }
}



import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int tc = 0; tc < commands.length; tc++) {
            List<Integer> tmp = new ArrayList<>();
            
            int i = commands[tc][0] -1;
            int j = commands[tc][1] -1;
            int k = commands[tc][2] -1;
            
            for(; i <= j; i++) {
                tmp.add(array[i]);                
            }
            
            Collections.sort(tmp);
            System.out.println(tmp.toString());
            
            
            answer.add(tmp.get(k));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
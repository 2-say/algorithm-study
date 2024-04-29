import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int start = arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(start);
        for(int i : arr) {
            if(start == i){
                continue;
            } else {
                list.add(i);
                start = i;
            }
        }
        return  list.stream().mapToInt(Integer::intValue).toArray();
    }
}
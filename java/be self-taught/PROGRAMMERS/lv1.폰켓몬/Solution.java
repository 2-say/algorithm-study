import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> typeMon = new HashSet();
        for(int i : nums) {
            typeMon.add(i);
        }
        
        if(typeMon.size() >= nums.length/2) {
            return nums.length/2;
        } 
        
        return typeMon.size();
    }
}
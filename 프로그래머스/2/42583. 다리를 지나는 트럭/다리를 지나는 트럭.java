import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int wet = weight;
        
        int l = 0;
        int[] time = new int[truck_weights.length];
        
        List<Integer> bridgeTruck = new ArrayList<>();
        
        int count = 0;
        
        while(count < truck_weights.length) {
            answer++;
            
            //트럭 소요 시간 처리
            for(int i : bridgeTruck) {
                time[i]++;
            }
            
            //다리 건넌 시간이면 제외
            for(int i = l; i < time.length; i++) {
                if(time[i] >= bridge_length) {
                    wet += truck_weights[i];
                    count++;
                    l++;
                }
            }
            
            //트럭태우기
            if(idx < truck_weights.length && wet >= truck_weights[idx]) {
                wet -= truck_weights[idx];
                bridgeTruck.add(idx);
                idx++;
            }
        }
        
        return answer;
    }
}
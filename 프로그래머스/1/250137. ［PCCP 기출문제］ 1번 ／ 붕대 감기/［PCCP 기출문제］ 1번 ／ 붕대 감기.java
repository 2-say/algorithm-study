import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> pt = new HashMap<>();
        int combo = 0, curHp = health;
        
        for(int[] a : attacks) pt.put(a[0], a[1]);
        
        for (int i = 0 ; i <= attacks[attacks.length-1][0]; i++) {
            if(pt.containsKey(i)) { //공격시간이면? 
                curHp -= pt.get(i);
                combo = 0;
            } else {
                //힐링타임
                curHp+=bandage[1]; //현재 hp + 1
                combo++; //콤보 증가
                if(combo == bandage[0]) {
                    //연속 콤보시 체력
                    combo = 0;
                    curHp += bandage[2];
                }
                
                curHp = (curHp > health) ? health : curHp; 
            }   
            //hp가 0보다 작으면 die... 주금.. ㅠㅠ
            if(curHp <= 0) return -1;
        }
        return curHp;
    }
}
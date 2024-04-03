import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int aInd = map.get(callings[i]);
            map.put(players[aInd-1], map.get(players[aInd-1])+1);
            map.put(callings[i] , map.get(callings[i]) - 1);
            swap(aInd-1 , aInd , players);
        }

        return players;
    }
    
    public static void swap(int aInd, int bInd, String[] players) {
        String tmp = players[aInd];
        players[aInd] = players[bInd];
        players[bInd] = tmp;
    }
}
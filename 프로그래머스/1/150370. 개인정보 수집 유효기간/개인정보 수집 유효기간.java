import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] duration = new int[26]; 
        
        for(String s : terms) duration[s.charAt(0)-65]=Integer.parseInt(s.substring(2,s.length()));

        int varToday = Integer.parseInt(today.substring(2,4))*1200
                        + Integer.parseInt(today.substring(5,7))*100
                        + Integer.parseInt(today.substring(8,10));        

        ArrayList<Integer> li = new ArrayList<>();


        for(int i=0; i<privacies.length; i++){

            int varDate = Integer.parseInt(privacies[i].substring(2,4))*1200
                + Integer.parseInt(privacies[i].substring(5,7))*100
                + Integer.parseInt(privacies[i].substring(8,10));

            int varTerm = duration[privacies[i].charAt(11)-65];

            if( varToday >= varDate + varTerm*100 ) li.add(i+1);
        }

        return li;
    }
}
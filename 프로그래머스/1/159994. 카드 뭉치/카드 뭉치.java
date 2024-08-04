class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0, idx2 = 0;
        int len = Math.max(cards1.length, cards2.length);
        String answer = "Yes";
        
        for(String word : goal) {
            boolean notFound = true;
            for(int i = 0 ; i < len ; i++) {
                if(idx1 >= i && i < cards1.length && cards1[i].equals(word)) {
                    notFound = false;
                    idx1 = i+1;
                    break;
                }
                if(idx2 >= i && i < cards2.length && cards2[i].equals(word)) {
                    notFound = false;
                    idx2 = i+1;
                    break;
                }
            }
            if(notFound) {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
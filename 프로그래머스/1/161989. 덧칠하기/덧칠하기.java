class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int ind = section[0] + m-1;  //색칠된 ind
        
        for(int i = 1 ; i < section.length; i++) {
            if(ind >= section[i]) continue;
            answer++;
            ind = section[i]+m-1;
        }
        return answer;
    }
}
class Solution {
    static int[] S;
    static int K;
    static int answer = 0;
    
    public int solution(int[] stones, int k) {
        S = stones;
        K = k;
        binarySearch(1, 200_000_000);
        return answer;
    }
    
    public void binarySearch(int s, int e) {
        while(s <= e) {
            int mid = (s + e) / 2;
            
            if(isPo(mid)) {
                s = mid + 1;
                answer = Math.max(answer, mid);
            } else {
               e = mid - 1;
            }
        }
    }
    
    
    public boolean isPo(int dec) {
        int count = 0;
        
        for(int s : S) {
            if((s - dec) < 0) count++;
            else count = 0;
            if(count == K) return false;
        }
        
        return true;
    }
    
}
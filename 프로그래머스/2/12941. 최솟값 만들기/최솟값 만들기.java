import java.util.*;

class Solution{
    static int answer;
    
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            answer+= (A[i] * B[A.length - i - 1]);
        }
        
        return answer;
    }
}
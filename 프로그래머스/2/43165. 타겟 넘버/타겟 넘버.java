class Solution {
    static int answer;
    static int T;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        T = target;
        dfs(0 ,0, numbers);
        return answer;
    }
    
    void dfs(int value, int curIdx, int[] numbers) {
        if(curIdx == numbers.length) {
            if(value == T) answer++;
            return;
        }
        
        //다음 결과에 2가지 경우로 전달
        dfs(value + numbers[curIdx], curIdx+1, numbers);
        dfs(value - numbers[curIdx], curIdx+1, numbers);
    }
    
}
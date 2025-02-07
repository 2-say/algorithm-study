class Solution {
    public int solution(int[] money) {
        int[] dp_first = new int[money.length];
        int[] dp_second = new int[money.length];
        
        for(int i = 0; i < money.length; i++) { //초기값 넣어놓기
            dp_first[i] = money[i];
            dp_second[i] = money[i];
        }
        
        dp_first[1] = -1; //1번째를 선택했을 경우
        dp_second[0] = -1; //2번째를 선택했을 경우
        dp_first[2] += dp_first[0]; 
        
        for (int i = 3; i < money.length; i++) { //3부터는 첫번째또는 두번째를 선택해올 수 있다.
            dp_first[i] += Math.max(dp_first[i - 2], dp_first[i - 3]);
            dp_second[i] += Math.max(dp_second[i - 2], dp_second[i - 3]);
        }
        
        int first_max = Math.max(dp_first[money.length - 2], dp_first[money.length - 3]); //첫번째를 골라온 것 중 마지막 값
        int second_max = Math.max(dp_second[money.length - 1], dp_second[money.length - 2]); //두번째 골라온 것 중 마지막 값
        return Math.max(first_max, second_max);
    }
}
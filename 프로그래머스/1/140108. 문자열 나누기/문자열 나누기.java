class Solution {
    public int solution(String s) {
        int result = 0; // 결과를 저장할 변수 초기화
        // 문자 개수를 저장할 배열. [0]은 target의 개수, [1]은 다른 문자의 개수
        int[] countArr = new int[2]; 
        char target = s.charAt(0); // 첫 번째 문자를 target으로 설정
        
        for (int i = 0; i < s.length(); i++) {
            if (target == s.charAt(i)) { // target 문자와 일치하는 경우
                countArr[0]++; // target 문자의 개수 증가
            } else { // target 문자와 일치하지 않는 경우
                countArr[1]++; // 다른 문자의 개수 증가
            }
            
            // target 문자와 다른 문자의 개수가 같아졌을 때
            if (countArr[0] == countArr[1]) {
                result++; // 균형 잡힌 문자열이 완성되었으므로 결과를 1 증가
                countArr = new int[2]; // 카운트 배열 초기화
                target = s.charAt((i+1) % s.length()); // 다음 target 문자 설정
            }
        }
        
        // 반복이 끝난 후에도 균형이 맞지 않는 경우 마지막 문자열 처리
        if (countArr[0] != countArr[1]) {
            return result + 1; // 남아있는 문자열을 포함하여 결과 반환
        }
        return result; // 최종 결과 반환
    }
}
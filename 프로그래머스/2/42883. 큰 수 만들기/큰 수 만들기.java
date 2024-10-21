import java.util.*;

class Solution {
    public String solution(String number, int k) {
        List<Integer> selects = new ArrayList<>();
        char[] cArr = number.toCharArray();
        int selectC = 0;
        int max = 0, idx = 0;
        for(int i = 0; i < number.length() - k; i++) { //선택할 글자
            for(int j = idx; j < number.length() - ((number.length() - k) - selectC - 1); j++) {
                if(max < (cArr[j] - '0')) {
                    max = cArr[j] - '0';
                    idx = j+1;
                    if(max == 9) break;
                }
            }
            selects.add(max);
            max = 0;
            selectC++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i  : selects) sb.append(i);
        return sb.toString();
    }
}
import java.util.*;

class Solution {
    Set<Integer> original, additional;
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int len = cards.length;
        original = new HashSet<>();
        additional = new HashSet<>();
        
        //처음 나눠준 카드
        int idx = len / 3; 
        for(int i = 0; i < idx; ++i) {
            original.add(cards[i]);
        }
        
        int target = len + 1; // n+1 값
        while(true) {
            answer++;
            //카드를 모두 사용했을 경우 종료
            if(idx >= len) {
                break;
            }
            
            //카드 2장 꺼내기
            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            idx += 2; //idx 2칸
            boolean flag = false;
            
            // 카드를 안받고 할 수있는지 체크
            for(int i : original) { //카드 순회
                if(original.contains(target - i)) { //두개 골라서 n+1 만들 수 있다면           
                    //두 카드 제거
                    original.remove(i); 
                    original.remove(target - i);
                    flag = true;
                    break;
                }
            }
            
            //위에서 해결 못했다면 카드 받자
            if(!flag) {
                if(coin > 0) {
                    for(int i : original) {
                        if(additional.contains(target - i)) {
                            original.remove(i);
                            additional.remove(target - i);
                            --coin;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(!flag) {
                if(coin > 1) {
                    for(int i : additional) {
                        if(additional.contains(target - i)) {
                            additional.remove(i);
                            additional.remove(target - i);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(!flag) {
                break;
            }
        }
        return answer;
    }
}

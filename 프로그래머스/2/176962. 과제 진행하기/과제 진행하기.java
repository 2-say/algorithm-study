import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<int[]> waitS = new Stack<>();
        
        //plans에서 시간순으로 정렬합니다.
        Arrays.sort(plans, (String[] o1, String[] o2) -> {
            String[] sp1 = o1[1].split(":");
            String[] sp2 = o2[1].split(":");
            if(!sp1[0].equals(sp2[0]))
                return Integer.compare(Integer.parseInt(sp1[0]), Integer.parseInt(sp2[0]));
            return Integer.compare(Integer.parseInt(sp1[1]), Integer.parseInt(sp2[1]));
        });
        
        String[] first = plans[0];
        int num = 0;
        
        for(int i = 1; i < plans.length; i++) {
            String[] sp1 = first[1].split(":");
            int m1 = Integer.parseInt(sp1[0]) * 60 + Integer.parseInt(sp1[1]) + Integer.parseInt(first[2]);
            
            String[] second = plans[i];
            String[] sp2 = second[1].split(":");
            int m2 = Integer.parseInt(sp2[0]) * 60 + Integer.parseInt(sp2[1]);
            
            //다음 과제가 더 빠를 경우 멈추고 Stack에 넣습니다.
            if(m1 > m2) {
                int leftM = (m1 - m2); //남은 시간 계산
                waitS.add(new int[]{ num, leftM });
            }
            
            //딱 맞춰서 끝났을 경우
            else if(m1 == m2) {
                answer.add(first[0]); //새로 시작하는 과제 진행
            }
            
            //과제가 끝나고 시간이 남을 경우
            else if(m1 < m2) {
                answer.add(first[0]);
                int leftT = (m2 - m1);
                
                while(!waitS.isEmpty()) { //대기중인 과제가 있을 경우, 
                    int[] left = waitS.pop();
                    
                    if(left[1] > leftT) {
                        left[1] -= leftT;
                        waitS.add(left); //안끝났으면 다시 넣고
                        break;
                    } else if(left[1] == leftT) {
                        answer.add(plans[left[0]][0]); //끝났다면 정답 처리한다.
                        break;
                    } else {
                        answer.add(plans[left[0]][0]); //끝났다면 정답 처리한다.
                        leftT -= left[1];
                    }
                }
            }
            
            //다음으로
            first = second;
            num = i;
        }
        
        answer.add(plans[num][0]); //마지막 과제 넣기
        while(!waitS.isEmpty()) { //남은 대기 중인 과제 해결
            int[] left = waitS.pop();
            answer.add(plans[left[0]][0]);
        }
        
        return answer;
    }
}
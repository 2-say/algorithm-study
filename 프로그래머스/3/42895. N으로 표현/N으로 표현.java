import java.util.*;

public class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        for(int i=0; i<9; i++) countList.add(new HashSet<>()); //모든 수를 담고
        countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

        for(int i=2; i<9; i++){
            Set<Integer> countSet = countList.get(i);

            for(int j=1; j<=i; j++){
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j); //N-1 N-2 N-3...계산

                for(int preNum : preSet){
                    for(int postNum : postSet) { //사칙연산 경우 계산
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);
                        if(preNum != 0 && postNum != 0) countSet.add(preNum / postNum);
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i))); //두 수를 붙힌 경우도 계산
        }

        for(Set<Integer> sub : countList){
            if(sub.contains(number))
                return countList.indexOf(sub);
        }

        return -1;
    }
}
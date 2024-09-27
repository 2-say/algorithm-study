import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        
        for(String c : operations) {
            String[] command = c.split(" ");
            if(command[0].equals("I")) {
                desc.add(Integer.parseInt(command[1]));
                asc.add(Integer.parseInt(command[1]));
            } else if(command[0].equals("D")) {
                //최솟값 삭제
                if(command[1].equals("-1")) {
                    desc.remove(asc.poll());
                } else {
                    asc.remove(desc.poll());
                }
            }
        }
        
        
        if(!desc.isEmpty() && !asc.isEmpty()) {
            answer.add(desc.poll());
            answer.add(asc.poll());
        } else {
            answer.add(0);
            answer.add(0);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;

class Solution {
    
    static class Process{
        int s;
        int e;
        
        Process(int s, int e) {
            this.s = s;
            this.e = s+e;
        }
        
        @Override
        public String toString() {
            return "( " + s + " " + e  +  ")";
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Process> que = new PriorityQueue<>((o1, o2) ->{return o1.s - o2.s;});
        PriorityQueue<Process> endQue = new PriorityQueue<>((o1, o2) ->{return (o1.e-o1.s) - (o2.e - o2.s);});
        for(int i = 0; i < jobs.length; i++) que.add(new Process(jobs[i][0], jobs[i][1]));
        
        int sum = 0;
        int time = 0;
        
        while(!que.isEmpty()) {
            if(que.peek().s > time) {
                time++;
                continue;
            }
            
            while(!que.isEmpty() && que.peek().s <= time) {
                endQue.add(que.poll());
            }
            
            if(!endQue.isEmpty()) {
                Process choiced = endQue.poll();
                sum += time + (choiced.e - choiced.s) - choiced.s;
                time += choiced.e - choiced.s;
                
                //다시 넣기
                while(!endQue.isEmpty()) que.add(endQue.poll());
            }
        }
        
        answer = sum / jobs.length;
        return answer;
    }
}
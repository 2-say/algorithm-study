import java.util.*;

class Solution {
    
    static class Process {
        int i;
        int v;
        
        Process(int i, int v) {
            this.i = i;
            this.v = v;
        }
        
        @Override
        public String toString() {
            return "(" + i + " " + v + ")";
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> que = new ArrayDeque<>();
        Queue<Process> tmp = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            que.add(new Process(i, priorities[i]));
        }
            
        while(true) {
            int max = 0;
            int idx = 0;
            int maxIdx = 0;
            int oriIdx = -1;
            
            //최대값 구하기
            while(!que.isEmpty()) {
                Process t = que.poll();
                
                if(max < t.v) {
                    max = t.v;
                    maxIdx = idx;
                    oriIdx = t.i;
                }
                
                idx++;
                tmp.add(t); //다시 저장
            }
            
            //이제 꺼내야하는게, 내가 원하던 거였다면 바로 return;
            if(oriIdx == location) return answer;
            
            //해당 인덱스 전 후로 나눠서 넣기
            Queue<Process> tmp1 = new ArrayDeque<>();
            
            int n = tmp.size();
            for(int i = 0 ; i < n; i++) {
                
                if(maxIdx > i) {
                    tmp1.add(tmp.poll());
                } else if(i == maxIdx) {
                    Process a = tmp.poll();
                    System.out.println(a.i + " " + a.v);
                } else {
                    que.add(tmp.poll());
                }
                
            }
            
            
            while(!tmp1.isEmpty()) {
                que.add(tmp1.poll());
            }
            
            answer++;
        }
        
        
    }
}
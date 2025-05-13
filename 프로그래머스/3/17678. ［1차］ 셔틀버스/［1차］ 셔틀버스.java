import java.util.*;

class Solution {
    static class Time implements Comparable<Time> {
        int hour;
        int min;
        boolean me;
        
        Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
            this.me = false;
        }
        
        @Override
        public int compareTo(Time o) {
            if(hour != o.hour) return Integer.compare(hour, o.hour);
            if(min != o.min) return Integer.compare(min, o.min);
            return Boolean.compare(me, o.me);
        }
    }
    
    static Queue<Time> pq = new PriorityQueue<>();
    static Stack<Time> stac = new Stack<>();
    
    public String solution(int n, int t, int m, String[] timetable) {
        // 데이터 넣고 정렬
        for(String ti : timetable) {
            String[] st = ti.split(":");
            int h = Integer.parseInt(st[0]);
            int mi = Integer.parseInt(st[1]);
            pq.add(new Time(h,mi));
        }
        
        int st = 9, sm = 0;
        int count = m; // 마지막 셔틀 탑승 가능 수;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pq.isEmpty()) break; // 모두 다 탑승 그만
                Time cur = pq.peek();
                int ht = 12000 * cur.hour + cur.min;
                int ht1 = 12000 * st + sm;
                
                if(ht <= ht1) {
                    if(i == n-1) count--; // 마지막 공석 체킹
                    stac.add(pq.poll());
                }
            }
            
            //다음 셔틀 시간
            sm += t;
            if(sm >= 60) {
                st++;
                sm = (sm - 60);
            }
        }
        
        sm -= t;
        // 공석이 남았다면 마지막 버스 시간에 탑승
        if(count > 0) return timeFormater(st, sm);
        else {
            Time lastT = stac.pop();
            return timeFormater(lastT.hour, lastT.min-1);
        }
    }
    
    // 시간계산 모듈
    public String timeFormater(int hour, int min) {
        if(min >= 60) {
            hour++;
            min = min - 60;
        } else if(min < 0) {
            hour--;
            min = 60 + min;
        }
        return String.format("%02d:%02d", hour, min);
    }
}
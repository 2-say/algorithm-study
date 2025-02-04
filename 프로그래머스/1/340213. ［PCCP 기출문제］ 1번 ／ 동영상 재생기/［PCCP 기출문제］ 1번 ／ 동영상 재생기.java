class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] ps = pos.split(":");
        String[] opsS = op_start.split(":");
        String[] opeS = op_end.split(":");
        String[] videoS = video_len.split(":");
        int tt = (Integer.parseInt(ps[0]) * 60) + (Integer.parseInt(ps[1]));
        int opst = (Integer.parseInt(opsS[0]) * 60) + (Integer.parseInt(opsS[1]));    
        int opet = (Integer.parseInt(opeS[0]) * 60) + (Integer.parseInt(opeS[1]));     
        int max_time = Integer.parseInt(videoS[0]) * 60 + Integer.parseInt(videoS[1]);
        
        for(String c : commands) {
            if(opst <= tt && opet >= tt) tt = opet;
            if(c.equals("next")) tt += 10;
            else if(c.equals("prev")) tt -= 10;
            if(tt < 0) tt = 0;
            if(tt > max_time) tt = max_time;
        }
        
        if(opst <= tt && opet >= tt) tt = opet;
        int munute = (tt / 60);
        int sec = (tt % 60);
        return String.format("%02d:%02d", munute, sec);
    }
}
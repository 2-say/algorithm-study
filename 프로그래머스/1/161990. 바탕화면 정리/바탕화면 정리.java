class Solution {
    public int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;
        int down = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for(int c = 0 ; c < wallpaper.length; c++) {
            //열 순회
            String[] splited = wallpaper[c].split("");
            for(int r = 0; r < splited.length; r++) {
                //행 순회
                if(splited[r].equals("#")) {
                    if(top > c) top = c;
                    if(down < c) down = c;
                    if(left > r) left = r;
                    if(right < r) right = r;
                }
            }
        }
        
        int[] answer = {top, left, down+1, right+1};
        return answer;
    }
}
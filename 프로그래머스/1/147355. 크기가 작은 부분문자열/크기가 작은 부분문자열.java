
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0 ; i < t.length() - p.length() + 1; i++) {
            String val = t.substring(i, i + p.length());
            if(Long.parseLong(val) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}
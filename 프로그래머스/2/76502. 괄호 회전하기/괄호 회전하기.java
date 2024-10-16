import java.util.*;

class Solution {
    public int solution(String s) {
        char[] cArr = s.toCharArray();
        int N = s.length();
        Stack<Character> stac = new Stack<>();
        int answer = 0;
        
        for(int i = 0; i < N-1; i++) {
            stac.clear();
            boolean flag = false;
            
            for(int j = i; j < N+i; j++) {
                int idx = j % s.length();
                flag = false;
                
                if(cArr[idx] == ']') {
                    while(!stac.isEmpty()) { 
                        char e = stac.pop();
                        if(e == '[') { 
                            flag = true;
                            break;
                        }
                    }
                } else if(cArr[idx] == '}') {
                    while(!stac.isEmpty()) {
                        char e = stac.pop();
                        if(e == '{') {
                            flag = true;
                            break;
                        }
                    }
                } else if(cArr[idx] == ')') {
                    while(!stac.isEmpty()) {
                        char e = stac.pop();
                        if(e == '(') { 
                            flag = true;
                            break;
                        }
                    }
                } else {
                    flag = true;
                    stac.add(cArr[idx]);
                }
                
                if(!flag) {
                    break;
                }
            }
            
            if(flag && stac.isEmpty()) answer++;
        }
        
        return answer;
    }
}
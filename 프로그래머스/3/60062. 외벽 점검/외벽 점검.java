import java.util.Arrays;

class Solution {
    private static int[] Weak;
    private static int length, answer;
    private static boolean[] used;
    
    public static int solution(int n, int[] weak, int[] dist) {
        length = weak.length;
        Weak = new int[length * 2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < length; j++) {
                Weak[j + (i *  length)] = weak[j] + (i * n); //-> 2배씩 늘려서 진행 두배로 만든다.
            }
        }
        
        Arrays.sort(dist);
        answer = -1;
        used = new boolean[dist.length];
        
        for(int i = 1; i <= dist.length; i++) {
            int[] org = new int[i]; 
            System.arraycopy(dist, dist.length - i, org, 0, i);
            //점차 인원을 늘려가며 시작 처음엔 긴거 한명
            backtrack(0, new int[i], org);
            if(answer >  0) {
                break;
            }
        }
        
        return answer;
    }
    
    //dist 배열의 친구들로 모든 외벽이 점검 가능한지 확인
    private static boolean check(int[] dist) { //제일 긴거 7짜리
        for(int i = 0; i < length; i++) { //0~12에서 모두 더한다.
            int idx = i;
            
            for(int distance: dist) {
                //7
                int position = Weak[idx++] + distance;
                while(idx < Weak.length && Weak[idx] <= position) {
                    idx++;
                }
            }
            
            
            if(idx - i >= length) {
                return true;
            }
        }
        
        return false;
    }
    
    
    private static void backtrack(int n, int[] dist, int[] org) {
        if(n == org.length) { //모두 사용했다면 종료
            if(check(dist)) answer = n;
            return;
        }
        
        for(int i = 0; i < org.length; i++) {
            if(!used[i]) {
                used[i] = true;
                dist[n] = org[i];
                backtrack(n + 1, dist, org);
                used[i] = false;
            }
        }
    }
    
    
}
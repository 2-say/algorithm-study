import java.util.*;

class Solution {
    
    static int N, current;
    static int[][] table;
    
    public String solution(int n, int k, String[] cmd) {
        table = new int[n+2][2];
        N = n;
        current = k+1;
        
        for(int i = 0; i < n+2; i++) { 
            table[i][0] = i-1; //바로 위 IDX
            table[i][1] = i+1; //바로 아래 IDX
        }
        
        Stack<Integer> trashBuffer = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'C') { //현재 행 삭제 후, 아래 행 선택
                trashBuffer.add(current);
                int up = table[current][0];
                int down = table[current][1];
                table[down][0] = up;
                table[up][1] = down;
                current = down > n ? up : down;
                  
            } else if (cmd[i].charAt(0) == 'D') { 
                for(int j = 0; j < Integer.parseInt(cmd[i].split(" ")[1]); j++) {
                    current = table[current][1];
                }
            } else if (cmd[i].charAt(0) == 'U') { 
                for(int j = 0; j < Integer.parseInt(cmd[i].split(" ")[1]); j++) {
                    current = table[current][0];
                }
            } else if (cmd[i].charAt(0) == 'Z') { //되돌리기
                int v = trashBuffer.pop();
                int up = table[v][0];
                int down = table[v][1];
                table[up][1] = v;
                table[down][0] = v;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for(int i : trashBuffer) answer[i-1] = 'X';
        return new String(answer);
    }
}

import java.util.*;

class Solution {
    static Stack<Integer> basket = new Stack<>();
    static int answer;
    
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] boardS = new Stack[board.length];
        answer = 0;
        for(int i = 0; i < board.length; i++) {
            boardS[i] = new Stack<>();
        }
        
        for(int i = board.length-1; i >= 0; i--) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0) boardS[j].push(board[i][j]);
            }
        }
        
        moveDoll(boardS, moves);
        return answer;
    }
    
    public void moveDoll(Stack<Integer>[] boardS, int[] moves) {
        for(int m : moves) {
            int idx = m - 1;
            if(boardS[idx].isEmpty()) continue;
            
            int p = boardS[idx].pop(); //넣으려는 값
            
            if(!basket.isEmpty() && basket.peek() == p) {
                basket.pop();
                answer+=2;
            } else {
                basket.push(p);
            }
            
            
        }
    }
}



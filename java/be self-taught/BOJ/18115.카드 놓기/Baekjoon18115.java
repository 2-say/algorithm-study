import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Baekjoon18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new ArrayDeque<>();
        //12345
        int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0 ; i < n; i++) {
            for (int j : que) {
                System.out.printf("%d ",j);
            }
            System.out.println();
            if(command[i] == 1){ //역순이니까 제일 뒤에 넣는다.
                Queue<Integer> tmp = new ArrayDeque<>();
                while(!que.isEmpty())
                    tmp.add(que.poll());
                que.add(n-(i));
                while(!tmp.isEmpty())
                    que.add(tmp.poll());
            }
            else if(command[i] == 2){ //두번째 넣는다.
                Queue<Integer> tmp = new ArrayDeque<>();
                while(que.size() > 1)
                    tmp.add(que.poll());
                que.add(n-(i));
                while(!tmp.isEmpty())
                    que.add(tmp.poll());
            }   
            else if(command[i] == 3){
                que.add(n-(i));
            }
        }

        
    }
}

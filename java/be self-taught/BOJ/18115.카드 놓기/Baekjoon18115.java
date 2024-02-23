import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Baekjoon18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //1
        StringBuilder sb = new StringBuilder();

        for(int i = 0, j =  command.length-1 ; i < n; j--, i++) {
            if(command[j] == 1)
                que.addFirst(i+1); 
            else if(command[j] == 2){ 
                int tmp = que.pollFirst();
                que.addFirst(i+1);
                que.addFirst(tmp);
            }
            else if(command[j] == 3)
                que.addLast(i+1);
        }
        for (int i : que) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}

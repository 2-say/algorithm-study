import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue que = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command==0) {
                if(que.isEmpty()) sb.append(0).append("\n");
                else sb.append(que.poll()).append("\n");
            } else{
                que.add(command);
            }
        }
        System.out.println(sb.toString());
    }
}

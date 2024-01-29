import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push_back"))
                que.addLast(Integer.parseInt(command[1]));
            if (command[0].equals("push_front"))
                que.addFirst(Integer.parseInt(command[1]));
            if (command[0].equals("front")){
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peekFirst());
            }
            if (command[0].equals("back")){
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peekLast());
            }
            if (command[0].equals("size"))
                sb.append(que.size());
            if (command[0].equals("empty")) {
                if (que.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
            }
            if (command[0].equals("pop_front")) {
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.pollFirst());
            }
            if (command[0].equals("pop_back")) {
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.pollLast());
            }
            if(!command[0].equals("push_back") && !command[0].equals("push_front"))
                sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

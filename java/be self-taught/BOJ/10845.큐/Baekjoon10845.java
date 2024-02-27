import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Baekjoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("push")) {
                que.add(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("front")){
                if(que.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(que.getFirst()).append("\n");
            }
            else if(input[0].equals("back")){
                if(que.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(que.getLast()).append("\n");
            }
            else if(input[0].equals("size")){
                sb.append(que.size()).append("\n");
            }
            else if(input[0].equals("empty")){
                if(que.isEmpty())
                    sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(input[0].equals("pop")){
                if(que.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(que.pop()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

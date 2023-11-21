import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stac = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] commandAndValue = br.readLine().split(" ");
            String command = commandAndValue[0];
            int value = 0;
            if (commandAndValue.length == 2) {
                value = Integer.parseInt(commandAndValue[1]);
            }
            if (command.equals("push")) {
                stac.push(value);
            } else if (command.equals("pop")) {
                if (stac.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stac.pop());
            } else if (command.equals("size")) {
                System.out.println(stac.size());
            } else if (command.equals("empty")) {
                if (stac.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (command.equals("top")) {
                if (stac.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stac.peek());
            }

        }

    }

}

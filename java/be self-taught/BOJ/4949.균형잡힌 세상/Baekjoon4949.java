import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (!input.equals(".")) {
                sb.append(solve(input)).append("\n");
            } else {
                System.out.println(sb.toString());
                break;
            }
        }
    }
    
    static public String solve(String input) {
        Stack<Character> stac = new Stack<>();
        // 넣고
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                stac.push(input.charAt(i));
            }
            if (stac.isEmpty() && (input.charAt(i) == ')' || input.charAt(i) == ']')) {
                return "no";
            }
            if (input.charAt(i) == ']' && stac.peek() == '(') {
                return "no";
            }
            if (input.charAt(i) == ')' && stac.peek() == '[') {
                return "no";
            }
            if (!stac.isEmpty() && input.charAt(i) == ')' && stac.peek() == '(') {
                stac.pop();
            }
            if (!stac.isEmpty() && input.charAt(i) == ']' && stac.peek() == '[') {
                stac.pop();
            }
        }
        if (stac.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] in = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stac = new Stack();

        for(int i = 0; i < in.length; i++) {
            if('A' <= in[i] && in[i] <= 'Z') sb.append(in[i]);
            else if(in[i] == '(') stac.add(in[i]);
            else if(in[i] == ')') {
                while(!stac.isEmpty()) {
                    if(stac.peek() == '(') {
                        stac.pop();
                        break;
                    }
                    sb.append(stac.pop());
                }
            } else {
                while(!stac.isEmpty() && (prior(in[i]) <= prior(stac.peek()))) {
                    sb.append(stac.pop());
                }
                stac.add(in[i]);
            }
        }

        while(!stac.isEmpty()) sb.append(stac.pop());
        System.out.println(sb);
    }

    static int prior(char op) {
        if(op == '(') return 0;
        else if(op == '+' || op == '-') return 1;
        else return 2;
    }
    
}
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String boom = br.readLine();
        solve(word, boom);
    }

    static void solve(String word, String boom) {
        int boomIdx = boom.length() - 1;
        Stack<Character> stac = new Stack();
        Stack<Character> buf = new Stack();

        for(int i = 0 ; i < word.length(); i++) {
            stac.add(word.charAt(i));
        }
        
        while(!stac.isEmpty()) {
            char w = stac.pop();
            if(w == boom.charAt(boomIdx)) boomIdx--;
            else {
                boomIdx = boom.length() - 1;
                if(w == boom.charAt(boomIdx)) boomIdx--;
            }

            buf.add(w);
            //폭탄일 경우,
            if(boomIdx < 0) {
                for(int i = 0; i < boom.length(); i++) buf.pop();
                for(int i = 0; i < boom.length(); i++) {
                    if(!buf.isEmpty())
                        stac.add(buf.pop());
                }
                boomIdx = boom.length() - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(buf.isEmpty()) {
            System.out.println("FRULA");
        } else {
            while(!buf.isEmpty()) sb.append(buf.pop());
        }

        System.out.println(sb);
    }
}
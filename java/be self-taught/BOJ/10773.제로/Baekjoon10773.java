import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baekjoon10773 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        Stack<Integer> stac = new Stack<>();

        for(int i = 0 ; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stac.pop();
            }else {
                stac.push(input);
            }
        }
        long result = 0;
        for (Integer integer : stac) {
            result += integer;
        }
        System.out.println(result);
    }
}
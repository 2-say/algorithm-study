import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solve();
    }

    public static void solve() {
        Stack<Integer> stac = new Stack();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int number = 1;
        for(int i = 1 ; i <= N*2; i++) {
            if(index >= N) {
                break;
            }
            if(!stac.isEmpty() && arr[index] == stac.peek()) {
                stac.pop();
                index++;
                sb.append("-").append("\n");
            }else {
                stac.push(number);
                sb.append("+").append("\n");
                number++;
            }
        }
        if(!stac.isEmpty()) {
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
    }

    
}
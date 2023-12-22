import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Baekjoon2023 {
    static List<Integer> answer;
    static int size ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        for(int i = 2 ; i <= 9; i++){
            if(isPrime(i))
                dfs(i);
        }
        answer.sort(Comparator.naturalOrder());
        for (int an : answer) {
            System.out.println(an);
        }
    }

    static void dfs(int start) {
        int max = 0;
        Stack<String> stac = new Stack<>();
        stac.add(String.valueOf(start));

        while (!stac.isEmpty()) {
            String n = stac.pop(); 
            max = Math.max(max,stac.size());
            if(n.length() == size){
                answer.add(Integer.parseInt(n));
                continue;
            }
            for (int i = 1; i <= 9; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(n);
                sb.append(String.valueOf(i));
                if (isPrime(Integer.parseInt(sb.toString()))) { 
                    stac.add(sb.toString()); 
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }

}

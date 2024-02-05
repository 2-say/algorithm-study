import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon2193 {
    static int answer;

    static class Info {
        int last;
        int size;
        public Info(int last, int size) {
            this.last = last;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(1, n);
        System.out.println(answer);
    }

    static void dfs (int s, int n) {
        Stack<Info> stac = new Stack<>();
        stac.add(new Info(s, 1));

        while(!stac.isEmpty()) {
            Info now = stac.pop();
            if(now.size > n)
                continue;
            if(now.size == n )
                answer++;
            if(now.last == 1)
                stac.add(new Info(0, now.size+1));
            else if(now.last == 0) {
                stac.add(new Info(0, now.size+1));
                stac.add(new Info(1, now.size+1));
            }
        }
    }


}

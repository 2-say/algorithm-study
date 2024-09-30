import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static int[] op; //연산자 개수
    static List<Integer> selectOp;

    static int min;
    static int max;
    static int N;

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selectOp = new ArrayList<>();

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if(depth == N-1) {
            int result = checkResult();
            if(max < result) max = result;
            if(min > result) min = result;
            return;
        }

        for(int i = 0; i < 4; i++) {

            if(op[i] >= 1) {
                op[i]--;
                Integer oper = i;
                selectOp.add(oper);
                dfs(depth + 1);
                selectOp.remove(selectOp.size() - 1); 
                op[i]++; 
            }
        }
    }

    static int checkResult() {
        int a = arr[0];
    
        for(int i = 0; i < N-1; i++) {
            int b = arr[i+1];
            Integer oper = selectOp.get(i);
            if(oper == 0) a = a + b;
            else if(oper == 1) a = a - b;
            else if(oper == 2) a = a * b;
            else if(oper == 3) a = a / b;
        }

        return a;
    }
}
 
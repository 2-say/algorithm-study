import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Baekjoon1966 {

    static class Docu {
        int priority;
        int num;

        public Docu(int priority, int num) {
            this.priority = priority;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            ArrayDeque<Docu> list = new ArrayDeque<>();
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int findPriority = Integer.parseInt(input[1]);
            
            String[] priorityList = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(new Docu(Integer.parseInt(priorityList[j]), j + 1));
            }
            solve(list, findPriority + 1);
        }
    }

    static private void solve(ArrayDeque<Docu> list, int findNum) {
        int rank = 0;
        while (!list.isEmpty()) {
            int maxP = getMaxP(list);
            Docu currP = list.peek();
            if (maxP > currP.priority) {
                Docu curr = list.pop();
                list.add(curr);
            } else {
                rank++;
                Docu print = list.pop();
                if (findNum == print.num) {
                    System.out.println(rank);
                }
            }
        }
    }

    private static int getMaxP(ArrayDeque<Docu> list) {
        int maxP = Integer.MIN_VALUE;
        for (Docu docu : list) {
            if (maxP < docu.priority) {
                maxP = docu.priority;
            }
        }
        return maxP;
    }
}

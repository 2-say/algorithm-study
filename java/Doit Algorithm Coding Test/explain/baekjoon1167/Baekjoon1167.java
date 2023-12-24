import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Baekjoon1167 {
    static List<Node>[] list;
    static boolean visited[];
    static int max = 0;
    static int node;

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);

        // int n = Integer.parseInt(br.readLine());

        int n = scan.nextInt();

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        // for (int i = 0; i < n; i++) {
        //     String[] input = br.readLine().split(" ");
        //     int u = Integer.parseInt(input[0]);
        //     for (int j = 1; j < input.length - 1; j += 2) {
        //         int cost = Integer.parseInt(input[j + 1]);
        //         int index = Integer.parseInt(input[j]);
        //         list[u].add(new Node(index, cost));
        //     }
        // }

        for(int i = 0; i < n; i++) {
            int s = scan.nextInt();
            while(true) {
                int e = scan.nextInt();
                if(e == -1) break;
                int cost = scan.nextInt();
                list[s].add(new Node(e, cost));
            }
        }

        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(node, 0);
        System.out.println(max);
    }

    static void dfs(int start, int cost) {
        if (cost > max) {
            max = cost;
            node = start;
        }
        visited[start] = true;
        for (Node next : list[start]) {
            if (!visited[next.index]){
                dfs(next.index, cost + next.cost);
                visited[next.index] = true;
            }
        }
    }
}

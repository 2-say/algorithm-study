import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon1414 {
    static PriorityQueue<Node> que;
    static int n;
    static int[] unionArr;

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        que = new PriorityQueue<>();
        unionArr = new int[n];
        // 유니온 파인드 초기화
        for (int i = 0; i < n; i++) {
            unionArr[i] = i;
        }

        int 모든비용 = 0;
        // 맵 연결 인접 행렬 저장
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (65 <= input.charAt(j) && input.charAt(j) <= 90) {
                    que.add(new Node(i, j, input.charAt(j) - 38));
                    모든비용 += input.charAt(j) - 38;
                } else if ('a' <= input.charAt(j) && input.charAt(j) <= 'z') {
                    que.add(new Node(i, j, input.charAt(j) - 96));
                    모든비용 += input.charAt(j) - 96;
                }
            }
        }

        int 사용한비용 = kruskal();

        int check = find(unionArr[0]);
        boolean allCheck = true;
        for (int i = 0; i < n; i++) {
            if (find(unionArr[i]) != check) {
                allCheck = false;
            }
        }
        if (allCheck)
            System.out.println(모든비용 - 사용한비용);
        else
            System.out.println(-1);

    }

    static int kruskal() {
        int 사용한비용 = 0;
        while (!que.isEmpty()) {
            Node next = que.poll();
            if ((next.s != next.e) && find(next.s) != find(next.e)) {
                union(next.s, next.e);
                사용한비용 += next.cost;
            }
        }
        return 사용한비용;
    }

    static int find(int a) {
        if (unionArr[a] == a)
            return a;
        else {
            return unionArr[a] = find(unionArr[a]);
        }
    }

    static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA != pB)
            unionArr[pA] = pB;
    }
}

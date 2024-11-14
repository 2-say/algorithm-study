import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] edgeCount;
    static int N;
    static List<Node>[] nList;
    static int[] time, resultTime;

    static class Node implements Comparable<Node> {
        int e, cost;

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nList = new List[N];
        time = new int[N];
        resultTime = new int[N];
        edgeCount = new int[N];

        for (int i = 0; i < N; i++) nList[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            time[i] = arr[0];
            resultTime[i] = time[i];  
            int jobN = arr[1];

            for (int j = 0; j < jobN; j++) {
                int dependency = arr[2 + j] - 1;
                nList[dependency].add(new Node(i, time[i]));
                edgeCount[i]++;
            }
        }

        System.out.println(topoSort());
    }

    static int topoSort() {
        Queue<Integer> q = new LinkedList<>();
        int maxTime = 0;

        for (int i = 0; i < N; i++) {
            if (edgeCount[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            maxTime = Math.max(maxTime, resultTime[cur]);

            for (Node next : nList[cur]) {
                resultTime[next.e] = Math.max(resultTime[next.e], resultTime[cur] + time[next.e]);
                edgeCount[next.e]--;

                if (edgeCount[next.e] == 0) {
                    q.add(next.e);
                }
            }
        }

        return maxTime;
    }
}

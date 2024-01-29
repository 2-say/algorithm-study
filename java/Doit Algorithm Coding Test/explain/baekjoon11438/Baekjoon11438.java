import java.io.*;
import java.util.*;

public class Baekjoon11438 {
    static int[] depth;
    static boolean[] visited;
    static List<Integer>[] list;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];
        depth = new int[n + 1];

        // 최대 2^k 값 구하기
        int k = 0;
        while (Math.pow(2, k) <= n)
            k++;

        parent = new int[k][n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 무방향 간선 연결
            list[s].add(e);
            list[e].add(s);
        }

        // 트리 깊이와 부모노드 저장하기
        bfs(1);
        // System.out.println(Arrays.toString(depth));

        // k 배열 채우기
        init(k, n);

        // System.out.println(Arrays.deepToString(parent));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lca(a, b, k);
        }

    }

    static void lca(int a, int b, int k) {
        // 길이가 긴쪽을 b로 통일
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        // 높이 같도록 맞춰주기 새로운 b 맞춤
        b = sameHeight(a, b, k);
        // System.out.println("a" + a);
        // System.out.println("b" + b);

        // 올라가면서 찾기
        int maxK = k - 1;

        // System.out.println(Arrays.deepToString(parent));

        int result = -1;
        while (maxK >= 0) {
            if (parent[maxK][a] != parent[maxK][b]) {
                a = parent[maxK][a];
                b = parent[maxK][b];
            }
            maxK--;
        }

        if (a == b) {
            System.out.println(a);
        } else if (result == -1)
            System.out.println(parent[0][a]);
        else
            System.out.println(result);
    }

    static int sameHeight(int a, int b, int k) {
        // 깊이 차이 계산
        int maxK = k - 1;

        // 높이 맞추기
        while (maxK >= 0) {
            if (Math.pow(2, maxK) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[maxK][b]]) {
                    b = parent[maxK][b];
                }
            }
            maxK--;
        }
        return b;
    }

    static void init(int k, int n) {
        for (int j = 1; j < k; j++) {
            for (int i = n; i >= 0; i--) {
                parent[j][i] = parent[j - 1][parent[j - 1][i]];
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new ArrayDeque();
        que.add(start);
        visited[start] = true;
        int level = 1;
        depth[start] = level;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    depth[next] = depth[cur] + 1;
                    parent[0][next] = cur;
                }
            }
        }
    }
}

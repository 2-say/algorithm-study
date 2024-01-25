import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11725 {

    static List<Integer>[] 간선리스트;
    static int[] 부모배열;
    static boolean[] 방문체크;

    static class 노드 {
        int 출발노드;
        int 도착노드;

        public 노드(int 출발노드, int 도착노드) {
            this.출발노드 = 출발노드;
            this.도착노드 = 도착노드;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader 버리 = new BufferedReader(new InputStreamReader(System.in));
        int 노드수 = Integer.parseInt(버리.readLine());
        부모배열 = new int[노드수 + 1];
        방문체크 = new boolean[노드수 + 1];
        부모배열[1] = 1;

        간선리스트 = new List[노드수 + 1];
        for (int ㄴ = 0; ㄴ <= 노드수; ㄴ++) {
            간선리스트[ㄴ] = new ArrayList<>();
        }

        for (int ㅇ = 0; ㅇ < 노드수 - 1; ㅇ++) {
            StringTokenizer 스토 = new StringTokenizer(버리.readLine());
            int 시작 = Integer.parseInt(스토.nextToken());
            int 끝 = Integer.parseInt(스토.nextToken());
            간선리스트[시작].add(끝);
            간선리스트[끝].add(시작);
        }

        너비우선탐색(1);

        for (int ㄴ = 2; ㄴ <= 노드수; ㄴ++) {
            System.out.println(부모배열[ㄴ]);
        }
    }

    static void 너비우선탐색(int 시작노드) {
        Queue<Integer> 큐 = new ArrayDeque<>();
        큐.add(시작노드);
        방문체크[시작노드] = true;

        while (!큐.isEmpty()) {
            int 현재 = 큐.poll();
            for (int 다음 : 간선리스트[현재]) {
                if (!방문체크[다음]) {
                    if (부모배열[현재] != 0)
                        부모배열[다음] = 현재;
                    else
                        부모배열[현재] = 다음;

                    방문체크[다음] = true;
                    큐.add(다음);
                }
            }
        }
    }
}

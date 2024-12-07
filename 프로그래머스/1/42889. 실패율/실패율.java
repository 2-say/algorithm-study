import java.util.*;

class Solution {
    static class Stage {
        int n;
        double faP;
        Stage(int n, double faP) {
            this.n = n;
            this.faP = faP;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        Queue<Stage> pq = new PriorityQueue<>((o1, o2) -> {
            if (Double.compare(o2.faP, o1.faP) == 0) return Integer.compare(o1.n, o2.n);
            return Double.compare(o2.faP, o1.faP);
        });
        

        for (int i = 1; i <= N; i++) {
            int clearFailPlayer = 0;
            int reachPlayer = 0;
            for (int s : stages) {
                if (i == s) {
                    clearFailPlayer++;
                    reachPlayer++;
                } else if (i < s) {
                    reachPlayer++;
                }
            }
            double failP = (reachPlayer == 0) ? 0 : (double) clearFailPlayer / reachPlayer;
            pq.add(new Stage(i, failP));
        }

        // 결과 배열 생성
        int[] result = new int[N];
        int idx = 0;
        while (!pq.isEmpty()) result[idx++] = pq.poll().n;
        return result;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] record = new double[N+2][2];
        
        for(int s : stages) {
            record[s][0]++;
            for(int j = s; j >= 1; j--) record[j][1]++;
        }
        
        Map<Integer, Double> m = new HashMap<>();
        for(int i = 1; i <= N; i++) {
             double rate = record[i][1] == 0 ? 0 : record[i][0] / record[i][1];
            m.put(i, rate);
        }
        
        return m.entrySet().stream()
            .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
            .thenComparing(Map.Entry.comparingByKey()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
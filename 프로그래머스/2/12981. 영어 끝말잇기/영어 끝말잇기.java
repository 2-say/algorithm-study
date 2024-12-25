import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> wordUsed = new HashMap<>();
        int[] counts = new int[n];

        wordUsed.put(words[0], true);
        counts[0]++;

        for (int i = 1; i < words.length; i++) {
            int player = i % n;
            counts[player]++;

            if (wordUsed.containsKey(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[]{player + 1, counts[player]};
            }

            wordUsed.put(words[i], true);
        }

        return new int[]{0, 0};
    }
}
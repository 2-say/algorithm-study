import java.io.*;
import java.util.*;

class Main {
    static Queue<Word> pq = new PriorityQueue<>();
    static Map<String, Integer> mp = new HashMap<>();

    static class Word implements Comparable<Word> {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if(cnt != o.cnt) return Integer.compare(o.cnt, cnt);
            if(word.length() != o.word.length()) return Integer.compare(o.word.length(), word.length());
            return word.compareTo(o.word);
        }
    }

	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);

        for(int i = 0; i < N; i++) {
            String w = br.readLine();
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }

        for(Map.Entry<String, Integer> et : mp.entrySet()) { //N
            pq.add(new Word(et.getKey(), et.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Word w = pq.poll();
            if(w.word.length() >= M) sb.append(w.word).append("\n");
        }

        System.out.println(sb);
    }
}

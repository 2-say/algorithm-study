import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Baekjoon1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> que = new PriorityQueue<>(new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return Integer.compare(a.length(), b.length());
            }
        });
        Set<String> st = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            st.add(word);
        }

        for (String string : st) {
            que.add(string);
        }

        // 우선순위 큐에서 요소를 하나씩 꺼내어 출력
        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }
        br.close();
    }
}

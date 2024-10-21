import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Map<Character, Integer> words = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String find = br.readLine();

        char[] cArr = find.toCharArray();
        for(int i = 0; i < find.length(); i++) { 
            if(words.containsKey(cArr[i])) {
                words.put(cArr[i], words.get(cArr[i]) + 1);
            } else words.put(cArr[i], 1);
        }

        int answer = 0;
        for(int i = 1; i < N; i++) {
            Queue<Character> q = new ArrayDeque<>();
            Map<Character, Integer> tmp = new HashMap<>(words);

            String target = br.readLine();
            char[] carr = target.toCharArray();
            int dN = 0;
            //해당 값 넣기
            for(int j = 0; j < carr.length; j++) q.add(carr[j]);

            while(!q.isEmpty()) {
                char c = q.poll();
                if(tmp.containsKey(c) && tmp.get(c) > 0) {
                    tmp.put(c, tmp.get(c) - 1);
                } else dN++;
            }

            if(target.length() < cArr.length) dN += cArr.length - target.length();

            if(dN < 2) answer++;
        }
        System.out.println(answer);
    }
}
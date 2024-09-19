import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = arr.length;
        for(int a : arr) {
            int left;
            if((left = (a - B)) > 0) {
                if(left%C != 0) answer += ((left/C) + 1);
                else answer += (left/C);
            }
        }

        System.out.println(answer);
    }
}
import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        M = Integer.parseInt(br.readLine());

        int answer = binarySearch(0, nums[nums.length-1]);
        if(M < calcTotal(answer)) answer--;
        System.out.println(answer);
    }
    static int binarySearch(int s, int e) {
        while(s < e) {
            int mid = (s + e)/2;

            if(M == calcTotal(mid)) return mid;
            else if(M > calcTotal(mid)) s = mid + 1;
            else e = mid;
        }

        return s;
    }
    
    static int calcTotal(int val) {
        int v = 0;
        for(int i = 0 ; i < N; i++) {
            if(val < nums[i]) v+= val;
            else v += nums[i];
        }
        return v;
    }
}
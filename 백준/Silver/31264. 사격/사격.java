import java.io.*;
import java.util.*;


class Main {

    static int[] arr;
    static int A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //
        M = Integer.parseInt(st.nextToken()); //
        A = Integer.parseInt(st.nextToken()); //진급 점수 최소 사격

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);

        int initP = 1;


        
        while(!solve(0, 0, initP)) {
            initP++;
        }

        System.out.println(initP);
    }


    static boolean solve(int point, int count, int gunP) {
        if(count == M) {
            if(point >= A) {
                return true;
            }
            return false;
        }


        int val = binarySearch(0, arr.length-1, gunP);
        point += val;
        gunP += val;

        return solve(point ,count+1, gunP);
    }

    static int binarySearch(int s, int e, int find) {
        int ans = -1;
        while(s <= e) {
            int mid = (s + e) / 2;

            if(arr[mid] <= find) {
                ans = arr[mid];
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return ans;
    }
}
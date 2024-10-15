import java.io.*;
import java.util.*;

class Main {

    static int[] ans = new int[2];
    static long val;
    static int[] solvent;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solvent = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        val = Long.MAX_VALUE;
        solve();
    }

    static void solve() {
        long min = Long.MAX_VALUE;
		int ml =0, mr = 0;

		for(int i = 0; i < n-1; i++) {
			int left = i+1; 
			int right = n-1;
			while(left<=right) {
				int mid = (left+right)/2;
				long sum = Math.abs(solvent[i]+solvent[mid]);
				
				if(min > sum) { //기록
					min = sum;
					ml = i; mr = mid;
				}

				if(solvent[mid] >= -solvent[i]) right = mid-1; //
                else left = mid+1;
			}
		}
		System.out.println(solvent[ml]+" "+solvent[mr]);
    }
}
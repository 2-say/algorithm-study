import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dpA = new int[arr.length];
        int[] dpD = new int[arr.length];
        
        for(int i = 0 ; i < arr.length; i++) {
            dpA[i] = 1;
            //LIS
            for(int j = 0; j < i ; j++) {
                if(arr[i] > arr[j])
                    dpA[i] = Math.max(dpA[i], dpA[j] + 1);
            }

            int ri = dpD.length - 1 - i;
            dpD[ri] = 1;

            //LDS
            for(int j = dpD.length - 1; ri < j; j--) {
                if(arr[ri] > arr[j])
                    dpD[ri] = Math.max(dpD[ri], dpD[j] + 1);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length; i++)
            if(max < dpA[i] + dpD[i]) max = dpA[i] + dpD[i];
            
        System.out.println(max-1);
    }
}
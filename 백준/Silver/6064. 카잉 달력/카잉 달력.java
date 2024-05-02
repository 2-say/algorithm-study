import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < tc; i++) {
            boolean hasA = false;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = arr[2]-1; j < arr[0] * arr[1] ; j += arr[0]) {
                if(j % arr[1] == arr[3]-1) {
                    hasA = true;
                    System.out.println(j+1);
                    break;
                }
            }
            if(!hasA)
                System.out.println("-1");
        }
    }   
}
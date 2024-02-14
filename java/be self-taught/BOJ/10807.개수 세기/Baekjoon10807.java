import java.io.*;
import java.util.*;

public class Baekjoon10807 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int find = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == find)
                result++;
        }
        System.out.println(result);
    }
}

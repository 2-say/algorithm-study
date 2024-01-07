import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2798 {
    static int find;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        find = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve(arr);
    }

    private static void solve(int[] arr){
        int min = Integer.MAX_VALUE;
        int ans=0;
        for(int i = 0 ; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k=j+1; k < arr.length; k++){
                    if(i != j && j != k && i!=k){
                        int value = arr[i] + arr[j] + arr[k];
                        if(find >= value && min > Math.abs(value - find) ){
                            min =  Math.abs(find- value);
                            ans = value;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

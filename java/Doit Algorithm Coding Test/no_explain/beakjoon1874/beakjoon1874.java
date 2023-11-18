package no_explain.beakjoon1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class beakjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num_arr = new int[n];
        ArrayList<String> ans = new ArrayList<>();

        Stack<Integer> stac = new Stack<>();
        int a = 0;
        boolean ans_flag = true;

        for(int i=0; i<n; i++){
            num_arr[i] = Integer.parseInt(br.readLine());
            
            while(a < num_arr[i]){
                a++;
                stac.push(a);
                ans.add("+");
            }
            if(stac.peek() > num_arr[i] ){
                ans_flag=false;
            }
            stac.pop();
            ans.add("-");
        }
        if(ans_flag){
            for (String anss : ans) {
                System.out.println(anss);
            }
        }
        else{
            System.out.println("NO");
        }
    }
}

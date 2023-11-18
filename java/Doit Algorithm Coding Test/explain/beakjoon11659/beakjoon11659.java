package explain.beakjoon11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon11659{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inum =  br.readLine().split(" ");
        String[] arrnum =  br.readLine().split(" ");
        int[] arr = new int[Integer.parseInt(inum[0]) + 1 ]; //6칸

        for(int i = 0; i < Integer.parseInt(inum[0]); i++)
        {
            arr[i+1] = Integer.parseInt(arrnum[i]) + arr[i];
        }

        for(int i = 0 ; i < Integer.parseInt(inum[1]); i++)
        {
            String[] sigmanum1 =  br.readLine().split(" ");
            int s = Integer.parseInt(sigmanum1[0]);
            int e = Integer.parseInt(sigmanum1[1]);
            System.out.println(arr[e]-arr[s-1]);
        }
    }
}
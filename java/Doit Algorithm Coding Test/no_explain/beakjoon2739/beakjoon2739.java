package no_explain.beakjoon2739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gogodan = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= 9 ; i++)
        {
            System.out.printf("%d * %d = %d\n",gogodan,i,gogodan*i);
        }

    }
}

package no_explain.beakjoon10809;

import java.util.Scanner;

public class beakjoon10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        for(int i=97; i < 123; i++ )
        {
            System.out.printf("%d",value.indexOf(i));
            if(i != 122)
            {
                System.out.print(" ");
            }
        }

    }
}
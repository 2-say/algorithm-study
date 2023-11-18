package no_explain.beakjoon2920;

import java.util.ArrayList;
import java.util.Scanner;

public class beakjoon2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] intlist = input.split(" ");
        int count = intlist.length;

        int[] values = new int[count];
        for(int i=0; i<count; i++)
        {
            values[i] = Integer.parseInt(intlist[i]);
        }

        int asc = values[0] ;
        int desc = values[0] ;
        int asc_continue_collect = 0 ;
        int desc_continue_collect = 0 ;

        for(int i = 0; i<values.length; i++)
        {   
            if(values[i]==asc)
            {
                asc++;
                asc_continue_collect++;
            }
            if(values[i]==desc)
            {
                desc_continue_collect++;
                desc--;
            }
        }
        if(asc_continue_collect == values.length)
        {
            System.out.println("ascending");
        }
        else if(desc_continue_collect == values.length)
        {
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }
    }
}

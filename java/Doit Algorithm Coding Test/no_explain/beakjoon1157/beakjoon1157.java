package no_explain.beakjoon1157;

import java.util.Scanner;

public class beakjoon1157
{
    public static void main(String[] args) {

        int[] arr = new int[26];
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        for(int i = 0 ; i<s.length(); i++)
        {
            if('A'<= s.charAt(i) && s.charAt(i) <= 'Z')
            {
                arr[s.charAt(i)-'A']++;
            }
        }
        int max = 0 ;
        char result='n';

        for(int i =0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
                result = (char)(i + 'A');
            }
            else if(max == arr[i])
            {
                result ='?';
            }
        }
        
        System.out.println(result);
        
    }
}
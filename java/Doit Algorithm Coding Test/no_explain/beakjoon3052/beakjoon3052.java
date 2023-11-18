package no_explain.beakjoon3052;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class beakjoon3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valueList[] = new int[10];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i < 10; i++)
        {
            valueList[i]=sc.nextInt();
            map.put(Integer.toString(valueList[i] % 42),1);
        }
        System.out.println(map.size());
        
        
    }
}

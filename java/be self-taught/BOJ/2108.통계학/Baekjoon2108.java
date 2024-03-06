import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Baekjoon2108 {

    static long[] arr;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for(int i = 0; i< n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        average();
        median();
        mode();
        range();
    }

    private static void average() {
        double tmp = Arrays.stream(arr).average().getAsDouble(); //1.833
        tmp = Math.round(tmp);
        System.out.println((long)tmp);
    }

    private static void median() {
        long[] sortedList = arr.clone();
        Arrays.sort(sortedList);
        int midIndx = arr.length / 2 ;
        System.out.println(sortedList[midIndx]);
    }

    private static void mode() {
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int MaxCount = 0;
        for (Entry<Long, Integer> l : map.entrySet()) {
            if(MaxCount < l.getValue())
                MaxCount = l.getValue();
        }
        List<Long> list = new ArrayList<>();
        for (Entry<Long, Integer> l : map.entrySet()) {
            if(MaxCount == l.getValue())
                list.add(l.getKey());
        }
        Collections.sort(list);
        if(list.size() >= 2) {
            System.out.println(list.get(1));
        }else {
            System.out.println(list.get(0));
        }
    }

    private static void range() {
        long minVal = Integer.MAX_VALUE ; 
        long maxVal = Integer.MIN_VALUE ; 

        for(int i = 0; i < arr.length; i++) {
            if(maxVal < arr[i])
                maxVal = arr[i];
            if(minVal > arr[i])
                minVal = arr[i];
        }
        System.out.println(maxVal-minVal);
    }
}

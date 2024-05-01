import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] copy = arr.clone(); //n
        
        Map<Integer, Integer> map = new HashMap();
        
        Arrays.sort(copy); //nlonn 
        int count = -1;
        for(int i : copy) { // n
            if(!map.containsKey(i)) //1
                count++;
            map.put(i, count); //1 
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        Queue<Integer> que = new PriorityQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < tc; i++ ) {
            
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                if(que.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(que.poll()).append("\n");
                }
            } else {
                que.add(value);
            }
        }
        System.out.println(sb.toString());
                                    
    }
}
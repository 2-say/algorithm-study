import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int floor = 1;
            int room = 1;
            while(count < num) {
                if(count % h == 0){
                    room++;
                    floor = 1;
                }else
                    floor++;
                count++;
            }
            sb.append(floor);
            if(room >= 10)
                sb.append(room);
            else
                sb.append(0).append(room);
            System.out.println(sb.toString());
        }
    }
}

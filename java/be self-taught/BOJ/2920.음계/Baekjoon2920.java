import java.io.*;
import java.util.*;

public class Baekjoon2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tr = -1;
        boolean dec = false;
        boolean asc = false;
        for(int i = 0; i < 8; i++) {
            int compare = Integer.parseInt(st.nextToken());
            if(i == 0 && compare == 1){
                tr = 1;
                asc = true;
            }
            if(i == 0 && compare == 8){
                tr = 8;
                dec = true;
            }
            if(dec){
                if(tr != compare)
                    dec = false; 
                tr--;
            }
            if(asc){
                if(tr != compare)
                    asc = false;
                tr++;
            }
        }
        if(asc) {
            System.out.println("ascending");
        }else if(dec)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}

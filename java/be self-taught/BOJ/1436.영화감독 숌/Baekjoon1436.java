import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String a = "666";
        int cnt = 1;
        while(cnt != n)
        {
            int val = Integer.parseInt(a);
            val++;
            a = String.valueOf(val);
            //667
            
            boolean cotiSix = false;
            //6 개수 연속적으로 3개인지 파악
            for(int i = 0 ; i < a.length()-2; i++){
                if(a.charAt(i) == '6' && a.charAt(i+1)=='6' && a.charAt(i+2)=='6'){
                    cotiSix = true;
                    break;
                }
            }
            if(cotiSix){
                cnt++;
            }
        }
        System.out.println(a);
    }
}

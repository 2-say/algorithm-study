import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Baekjoon2231 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solve(input));
    }

    static int solve(String input){
        int countN=1;
        int answer=0;
        while(countN <= Integer.parseInt(input)){
            String num = String.valueOf(countN); 
            System.out.printf("%d \n",countN);
            for(int i = 0 ; i <num.length(); i++ ){
                answer += num.charAt(i)-'0';
            }
            answer += countN;
            if(answer == Integer.parseInt(input)){
                return countN;
            }
            answer=0;
            countN++;
        }
        return 0;
    }
}
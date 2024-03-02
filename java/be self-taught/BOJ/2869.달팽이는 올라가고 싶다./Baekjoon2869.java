import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long v = Long.parseLong(input[2]);
        
        long day = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0)
            day++;
        System.out.println(day);
    }
}

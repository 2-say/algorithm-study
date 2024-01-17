import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Double result = 0.0;

        double[] pointArr= Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Arrays.sort(pointArr);
        double m = pointArr[n-1];

        for (double i : pointArr) {
            Double tmp = ( i  / m ) * 100.0 ;
            result += Math.round((tmp* 100.0))/ 100.0 ;
        }
        result = result / n ;
        System.out.println(result);
    }
}

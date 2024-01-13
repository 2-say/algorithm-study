import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int currHour = Integer.parseInt(st.nextToken());
        int currMin = Integer.parseInt(st.nextToken());
        int resultM, resultH;

        resultH = currHour;
        if (currMin < 45) {
            resultM = 60 - (45 - currMin);
            resultH = currHour - 1;
        } else
            resultM = currMin - 45;

        if (resultH < 0) {
            resultH = 23;
        }

        System.out.println(resultH + " " + resultM);

    }
}

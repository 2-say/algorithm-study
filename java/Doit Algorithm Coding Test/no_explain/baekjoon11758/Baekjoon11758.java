import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11758 {

    static int[] xyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        xyArr = new int[6];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xyArr[idx] = Integer.parseInt(st.nextToken());
            idx++;
            xyArr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        solve();
    }

    public static void solve() {
        int ccw = 0;
        ccw += xyArr[0] * xyArr[3];
        ccw += xyArr[2] * xyArr[5];
        ccw += xyArr[4] * xyArr[1];
        ccw -= xyArr[2] * xyArr[1];
        ccw -= xyArr[4] * xyArr[3];
        ccw -= xyArr[0] * xyArr[5];
        if (ccw < 0)
            System.out.println(-1);
        else if (ccw == 0)
            System.out.println(0);
        else
            System.out.println(1);
    }
}

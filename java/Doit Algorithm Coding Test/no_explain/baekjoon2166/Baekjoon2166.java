import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2166 {

    static class P {
        long x;
        long y;

        public P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<P> pList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            P p = new P(x, y);
            pList.add(p);
        }
        solve();
    }

    public static void solve() {
        double result = 0;
        for(int i = 0; i < pList.size(); i++) {
            result += (double)pList.get(i).x * pList.get((i+1) % pList.size()).y ;
            result -= (double)pList.get(i).y * pList.get((i+1) % pList.size()).x ;
        }
        System.out.printf("%.1f", Math.abs(result / 2));
    }
}

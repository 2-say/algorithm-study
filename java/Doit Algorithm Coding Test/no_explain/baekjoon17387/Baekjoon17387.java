import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon17387 {

    static P p1;
    static P p2;
    static P p3;
    static P p4;
    static long ccw1;
    static long ccw2;
    static long ccw3;
    static long ccw4;

    static class P {
        long x;
        long y;
        
        public P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] first = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] second = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        p1 = new P(first[0], first[1]);
        p2 = new P(first[2], first[3]);
        p3 = new P(second[0], second[1]);
        p4 = new P(second[2], second[3]);

        ccw1 = ccw(p1, p2, p3);
        ccw2 = ccw(p1, p2, p4);
        ccw3 = ccw(p3, p4, p1);
        ccw4 = ccw(p3, p4, p2);

        System.out.println(checkCCW());
        
    }

    public static long ccw(P p1, P p2, P p3) {
        long ccw = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - 
        ((p2.x * p1.y) + (p3.x * p2.y) + (p1.x * p3.y));
        if(ccw > 0)
            return 1;
        else if(ccw < 0)
            return -1;
        else 
            return 0;
    }


    static int checkCCW(){
        int result = 0;
        boolean check = false;
        // 일직선일 때
        if ((ccw1 * ccw2 == 0) && (ccw3 * ccw4 == 0)) {
            // 일직선인데 겹칠 때
            check = true;
            if (Math.max(p3.x, p4.x) >= Math.min(p1.x, p2.x) && Math.max(p1.x, p2.x) >= Math.min(p3.x, p4.x)
                    && Math.max(p3.y, p4.y) >= Math.min(p1.y, p2.y) && Math.max(p1.y, p2.y) >= Math.min(p3.y, p4.y)){
                result = 1;
            }
        }
        if ((ccw1 * ccw2) <= 0 && (ccw3 * ccw4) <= 0  && !check){
            result = 1;
        }
        return result;
    }
}

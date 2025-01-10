import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            String[] in = br.readLine().split(" ");
            int x1 = Integer.parseInt(in[0]);
            int y1 = Integer.parseInt(in[1]);
            int r1 = Integer.parseInt(in[2]);
            int x2 = Integer.parseInt(in[3]);
            int y2 = Integer.parseInt(in[4]);
            int r2 = Integer.parseInt(in[5]);

            System.out.println(calPosition(x1, y1, r1, x2, y2, r2));
        }

    }


    private static int calPosition(int x1, int y1, int r1, int x2, int y2, int r2) {
        //두 점 사이의 거리 계산
        double dis = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
        if(x1 == x2 && y1 == y2 && r1 != r2) return 0;
        if(x1 == x2 && y1 == y2 && r1 == r2) return -1;
        if(r1+r2 < dis || Math.pow((r1-r2),2) > dis*dis)  return 0;
        if(r1+r2 == dis || Math.pow((r1-r2),2) == dis*dis) return 1;
        if(Math.pow((r1+r2),2) > dis*dis && Math.pow((r1-r2),2) < dis*dis) return 2;
        return -1;
    }
}

import java.io.*;
import java.util.*;

class Baekjoon15552 {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String result = String.valueOf(a+b);
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
    }
}
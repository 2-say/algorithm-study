import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] tshirt = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        String[] tp = br.readLine().split(" ");
        double T = Double.parseDouble(tp[0]);
        int P = Integer.parseInt(tp[1]);
        int a1 = 0;
        
        for(int i = 0; i < tshirt.length; i++) {
            a1 += Math.ceil(tshirt[i] / T);
        }
        
        System.out.println(a1);
        System.out.println(N/P + " " + N%P);
    }
}
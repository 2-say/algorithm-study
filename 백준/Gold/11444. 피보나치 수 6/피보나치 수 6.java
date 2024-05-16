import java.io.*;
import java.util.*;

class Main {
    
    static int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        if(n == 0) System.out.println(0);
        else {
            long[][] arr = {{1,1} ,{1,0}};
            long[][] result = arrPow(arr, n);
            System.out.println(result[1][0] % MOD);
        }
        br.close();
    }
    
    public static long[][] arrPow(long[][] a, long n) {
        if(n == 1) return a;
        long[][] temp = arrPow(a, n/2);
        
        if(n % 2 ==0) return arrMul(temp, temp);
        else
            return arrMul(arrMul(temp, temp), a);
    }
    
    public static long[][] arrMul(long[][] a, long[][] b) {
        long[][] temp = new long[2][2];
        for(int i = 0; i <2 ; i++) {
            for(int j = 0; j <2 ; j++) {
                for(int k = 0; k <2 ; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }

}
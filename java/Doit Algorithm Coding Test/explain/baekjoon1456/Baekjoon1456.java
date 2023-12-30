import java.io.*;
class Baekjoon1456 {
    static boolean[] isNPrime ;
    static boolean[] almostP ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);
        isNPrime = new boolean[(int)Math.sqrt(max)+1];
        almostP = new boolean[(int)Math.sqrt(max)+1];
        eratos((int)Math.sqrt(max));

        System.out.println(almostP(min, max));
    }

    static void eratos(long max){
        isNPrime[0] = true;
        isNPrime[1] = true;
        for(int i = 2 ; i <= max; i++){
            for(int j =2 ; j*i <= max; j++){
                isNPrime[j*i] = true;
            }
        }
    }

    

    static int almostP(long min, long max){
        int ans = 0;
        for(long i = 2 ; i < isNPrime.length; i++){
            if(isNPrime[(int)i] != true){
                for(long j = 2 ; (long)Math.pow(i, j) <= max; j++){
                    if((long)Math.pow(i, j) >= min){
                        ans++;
                    }
                    else{
                        continue;
                    }
                }
            }
        }

        return ans;
    }

    


}
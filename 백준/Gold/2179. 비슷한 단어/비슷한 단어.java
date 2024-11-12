import java.io.*;
import java.util.*;


class Main { 
    static int N;
    static String[] arr;
    static int ai; 
    static int bi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        int minLen = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for(int i = 0; i < N-1; i++) {
            String a = arr[i];            
            for(int j = i + 1; j < N; j++) {
                String b = arr[j];

                int aIdx = 0;

                while(aIdx < a.length() && aIdx < b.length()) {
                    if(a.charAt(aIdx) != b.charAt(aIdx)) break;
                    aIdx++;
                }

                if(minLen < aIdx) {
                    minLen = aIdx; 
                    ai = i;
                    bi = j;
                }
            }
        }

        System.out.println(arr[ai]);
        System.out.println(arr[bi]);
    }

}
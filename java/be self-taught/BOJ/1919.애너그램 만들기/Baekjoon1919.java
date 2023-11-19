import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1919 {
    static boolean[] visited1;
    static boolean[] visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        visited1 = new boolean[input1.length()];
        visited2 = new boolean[input2.length()];

        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                if (input1.charAt(i) == input2.charAt(j) && visited1[i] != true && visited2[j] != true) {
                    visited1[i] = true;
                    visited2[j] = true;
                }
            }
        }
        int count1 =0;
        int count2 =0;
        for(int i = 0 ; i < visited1.length; i++) {
            if(visited1[i]) {
                count1++;
            }
        }
        for(int i = 0 ; i < visited2.length; i++) {
            if(visited2[i]) {
                count2++;
            }
        }
        System.out.println(input1.length() - count1  + input2.length() - count2);
    }
}

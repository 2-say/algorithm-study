import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1018 {

    static char[][] input;
    static int[][] correctBArr;
    static int[][] correctWArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();

        correctBArr = new int[8][8];
        correctWArr = new int[8][8];
        input = new char[n][m];

        correctBArr[0][0] = -1; // B
        correctWArr[0][0] = 1; // W

        for (int i = 0; i < 8; i++) {
            if (i - 1 >= 0) {
                correctBArr[i][0] = correctBArr[i-1][0] * -1;
                correctWArr[i][0] = correctWArr[i-1][0] * -1;
            }
            for (int j = 0; j < 8; j++) {
                if (j - 1 >= 0) {
                    correctBArr[i][j] = correctBArr[i][j-1] * -1;
                    correctWArr[i][j] = correctWArr[i][j-1] * -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            for (int j = 0; j < m; j++) {
                input[i][j] = in.charAt(j);
            }
        }

        answer.add(check(0, 0));

        if (n > 8 && m > 8) {
            for (int i = 0; i <= n - 8; i++) {
                for (int j = 0; j <= m - 8; j++) {
                    answer.add(check(i, j));
                }
            }
        } else if (n > 8) {
            for (int i = 1; i <= n - 8; i++) {
                answer.add(check(i, 0));
            }
        } else if (m > 8) {
            for (int i = 1; i <= m - 8; i++) {
                answer.add(check(0, i));
            }
        }  

        Collections.sort(answer);
        System.out.println((answer.get(0)));
    }

    static int check(int starti, int startj) {
        int result1 = 0;
        int result2 = 0;
        int ii = 0 ;
        int jj = 0 ;
 
        for (int i = starti; i < starti+8; i++) {
            for (int j = startj; j < startj+8; j++) {
                if (input[i][j] == 'W' && correctWArr[ii][jj] != 1) {
                    result1++;
                } else if (input[i][j] == 'B' && correctWArr[ii][jj] != -1) {
                    result1++;
                }
                jj++;
            }
            jj = 0;
            ii++;
        }

        ii = 0 ;
        jj = 0 ;

        for (int i = starti; i < starti+8; i++) {
            for (int j = startj; j <startj+8; j++) {
                if (input[i][j] == 'B' && correctBArr[ii][jj] != -1) {
                    result2++;
                }
                if (input[i][j] == 'W' && correctBArr[ii][jj] != 1) {
                    result2++;
                }
                jj++;
            }
            jj = 0;
            ii++;
        }
        return Math.min(result1, result2);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11403 {

    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                if(input[j].charAt(0) == '1'){
                    list[i][j] = 1;
                }
                else list[i][j] = 0;
            }
        }
        for(int k = 0; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0; j < n; j++){
                    if( list[i][k] == 1  && list[k][j] == 1){
                        list[i][j] = 1;
                    }
                }
            }
        }

        //출력
        for(int i = 0; i < n ; i++){
            for(int j= 0; j< n; j++){
                System.out.printf("%d ",list[i][j]);
            }
            System.out.println();
        }
    }
}

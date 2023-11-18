package explain.beakjoon11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon11660{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inStrings = br.readLine().split(" ");  //처음 입력값
        int n = Integer.parseInt(inStrings[0]);  //표의 크기
        int[][] sarr = new int[n+1][n+1];  //1부터 시작하도록 n+1
        int[][] arr = new int[n][n];

        String[] cStrings ;
   
        //표 만들기
        for(int i=0; i<n; i++) 
        {
            cStrings = br.readLine().split(" ");  
            for(int j=0 ;j<n; j++)
            {
                arr[i][j]=Integer.parseInt(cStrings[j]); 
            }
        }  
        
        //구간합표 만들기
        sarr[1][1] = arr[0][0];
        for(int i=0; i<n; i++)
        {
            for(int j=0 ;j<n; j++)
            {
                if((i-1)>=0 && (j-1)>=0){
                    sarr[i+1][j+1] = sarr[i][j+1] + sarr[i+1][j] + arr[i][j] - sarr[i][j];
                }
                else if((j-1)<0 && (i-1)>=0) //j=0 0열 일경우
                {
                    sarr[i+1][j+1] = sarr[i][j+1] + arr[i][j] ;
                }
                else if(i-1<0 && j-1>=0) //i=0 0행 일경우
                {
                    sarr[i+1][j+1] = sarr[i+1][j] + arr[i][j] ;
                }
            }
        }   
        int result= 0;

          
        for(int i =0 ; i < Integer.parseInt(inStrings[1]); i++)
        {
            String[] dStrings = br.readLine().split(" "); 
            int x1 = Integer.parseInt(dStrings[0]);
            int y1 = Integer.parseInt(dStrings[1]);
            int x2 = Integer.parseInt(dStrings[2]);
            int y2 = Integer.parseInt(dStrings[3]);
            
            result = sarr[x2][y2] 
            - sarr[x1-1][y2] 
            - sarr[x2][y1-1]
            + sarr[x1-1][y1-1]; 
            
            System.out.println(result);
        }

    }
}

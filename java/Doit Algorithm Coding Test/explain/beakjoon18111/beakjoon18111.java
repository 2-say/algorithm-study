package explain.beakjoon18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class beakjoon18111 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" "); // 정보 입력
        int height =Integer.parseInt(info[0]);  
        int width =Integer.parseInt(info[1]);  
        int block =Integer.parseInt(info[2]);
        int resultHeight1 = 0; 
        int resultTime1 =0 ;

        String[] rStrings = new String[height];
        int[][] map = new int[height][width];
        int[][] map_copy = new int[height][width];

        int min = Integer.MAX_VALUE;
        int minHeight = 0;
    
        for(int i=0; i<height; i++)
        {
            rStrings = br.readLine().split(" ");
            for(int j=0; j<width; j++)
            {
                map[i][j] = Integer.parseInt(rStrings[j]);
            }
        }
        //맵 입력   //맵 복사본에서 작업
        for (int i = 0; i < map.length; i++) {
            map_copy[i] = Arrays.copyOf(map[i], map[i].length);
        }
      

        int needBlock = 0;
        int rowIndex = -1;
        int colIndex = -1;
        






        int max1 = Arrays.stream(map_copy).flatMapToInt(Arrays::stream).max().getAsInt();
        // 필요한 블럭 수 파악
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
            {
                needBlock += max1 - map_copy[i][j];
            }
        }
    
        // System.out.println("need block"+ needBlock);

        //처음에 완성할 수 있으면 완성해 
        if(block >= needBlock)
            {
                resultTime1 += needBlock * 1;
                resultHeight1 = max1;

                // 완성했는데, 최단 기록이면 저장
                if(resultTime1 < min){
                    min = resultTime1; 
                    minHeight = resultHeight1;
                    resultTime1 = 0 ;
                }
            }


        // 평평할 때 까지 민다.
        while(needBlock != 0){
            // 완성할 수 없다 == 블록수가 부족 -> 그럼 한칸 깎고 다시 보자.

            // 제일 높은 위치 블럭 파악
            int max = Integer.MIN_VALUE;
            for(int i=0; i<height; i++)
            {
                for(int j=0; j<width; j++)
                {
                    if (map_copy[i][j] > max) {
                        max = map_copy[i][j];
                        rowIndex = i;
                        colIndex = j;
                    }
                }
            }
        
            map_copy[rowIndex][colIndex]-- ; // 깎기
            resultTime1+=2; //시간 
            block++;  //블록 먹기


            int max2 = max -1 ;
            // 깎고나서 다시 필요한 블록 수 파악
            needBlock = 0;
            for(int i=0; i<height; i++) 
            {
                for(int j=0; j<width; j++)
                {
                    needBlock += max2 - map_copy[i][j];
                }
            }
            
            
            if(block >= needBlock  && needBlock != 0)
            {
                resultTime1 += (needBlock * 1);
                resultHeight1 = max1;
                // 완성했는데, 최단 기록이면 저장
                if(resultTime1 < min){
                    min = resultTime1; 
                    minHeight = resultHeight1;
                }
            }

        }
        //마지막에 평평할때까지 밀고 나서 결과 시간 비교
        int max3 = Arrays.stream(map_copy).flatMapToInt(Arrays::stream).max().getAsInt(); //제일 높은 위치
        if(resultTime1 < min){
                    min = resultTime1; 
                    minHeight = max3;
                    resultTime1 = 0 ;
        }

        System.out.printf("%d %d",min,minHeight);
        
    }
}

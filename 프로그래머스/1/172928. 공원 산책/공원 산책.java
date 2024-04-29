
import java.util.*;

class Solution {
    
    static class Point {
    int x;
    int y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }    
    
    static String[][] map;
    
    
    public int[] solution(String[] park, String[] routes) {
        
        int n = park.length;
        int m = park[0].split("").length;
        map = new String[n][m];
        Point sP = null;
        
        for(int i = 0; i < n; i++) {
            String[] input = park[i].split("");
            for(int j = 0 ; j < m; j++) {
                map[i][j] = input[j];
                if(input[j].equals("S")) {
                    sP = new Point(i, j);
                }
            }
        }
        
        for(int i = 0 ; i < routes.length; i++) {
            String[] command = routes[i].split(" ");
            
            int nX = sP.x;
            int nY = sP.y;
            
            boolean isP = false;
            
            if(command[0].equals("N")) {
                nX = sP.x - Integer.parseInt(command[1]);
                for(int a = nX; a <= sP.x; a++) {
                    if(nX < 0 || nY < 0 || nX >= n || nY >= m || map[a][nY].equals("X")) {
                        isP = true;
                        break;
                    }
                }
                
            }
            else if(command[0].equals("S")) {
                nX = sP.x + Integer.parseInt(command[1]);
                for(int a = sP.x; a <= nX; a++) {
                    if(nX < 0 || nY < 0 || nX >= n || nY >= m || map[a][nY].equals("X")) {
                        isP = true;
                        break;
                    }
                }
            }
            else if(command[0].equals("W")) {
                nY = sP.y - Integer.parseInt(command[1]);
                for(int a = nY; a <= sP.y; a++) {
                    if(nX < 0 || nY < 0 || nX >= n || nY >= m || map[nX][a].equals("X")) {
                        isP = true;
                        break;
                    }
                }
            }
            else if(command[0].equals("E")) {
                nY = sP.y + Integer.parseInt(command[1]);
                for(int a = sP.y; a <= nY; a++) {
                    if(nX < 0 || nY < 0 || nX >= n || nY >= m || map[nX][a].equals("X")) {
                        isP = true;
                        break;
                    }
                }
            }
            
            if(!isP) {
                sP.x = nX;
                sP.y = nY;
            }
        }
        
        int[] answer = {sP.x , sP.y};
        return answer;
    }
}
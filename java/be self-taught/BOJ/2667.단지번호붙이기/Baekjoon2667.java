import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baekjoon2667 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[][] colorMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        colorMap = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int color = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j,color);
                    color++;
                }
            }
        }

        Map<Integer, Integer> result = new HashMap();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(colorMap[i][j] != 0) {
                    if(result.containsKey(colorMap[i][j])){
                        result.put(colorMap[i][j], result.get(colorMap[i][j])+1) ;
                    }else{
                        result.put(colorMap[i][j], 1);
                    }
                }
            }
        }

        System.out.println(result.size());
        List<Integer> ans = new ArrayList<>();
        
        for (Map.Entry<Integer,Integer> e : result.entrySet()) {
            ans.add(e.getValue());
        }

        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }


    }

    static void dfs(int sX, int sY, int color) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        Stack<Point> stac = new Stack();
        visited[sX][sY] = true;
        colorMap[sX][sY] = color;
        stac.add(new Point(sX, sY));
        
        while (!stac.isEmpty()) {
            Point curr = stac.pop();

            for (int i = 0; i < 4; i++) {
                int nX = curr.x + dx[i];
                int nY = curr.y + dy[i];
                
                if(isValid(nX, nY)) {
                    visited[nX][nY] = true;
                    colorMap[nX][nY] = color;
                    stac.add(new Point(nX, nY));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >=0 && y >=0 && x < map.length && y < map[0].length && map[x][y] != 0 && !visited[x][y];
    }
}

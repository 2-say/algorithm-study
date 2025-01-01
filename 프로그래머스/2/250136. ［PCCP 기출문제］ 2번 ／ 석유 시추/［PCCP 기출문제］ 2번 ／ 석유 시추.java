import java.util.*;

class Solution {
    static int xLen, yLen;
    static Map<Integer, Integer> loafMap = new HashMap<>(); // 영역별 크기를 저장하는 맵

    public int solution(int[][] land) {
        int answer = 0;
        yLen = land.length;
        xLen = land[0].length;
        
        drawColor(land);

        answer = findMaxPlace(land);

        return answer;
    }

    int findMaxPlace(int[][] land) {
        int answer = 0;

        for (int x = 0; x < xLen; x++) {
            Map<Integer, Integer> columnCount = new HashMap<>();
            int maxLoaf = 0;

            for (int y = 0; y < yLen; y++) {
                int color = land[y][x];
                if (color > 0) {
                    columnCount.put(color, columnCount.getOrDefault(color, 0) + 1);
                }
            }

            for (int color : columnCount.keySet()) {
                maxLoaf += loafMap.get(color);
            }
            
            answer = Math.max(answer, maxLoaf);
        }

        return answer;
    }

    void drawColor(int[][] land) {
        int color = 1;
        boolean[][] visited = new boolean[yLen][xLen];

        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int areaSize = dfs(land, i, j, visited, color);
                    loafMap.put(color, areaSize);
                    color++;
                }
            }
        }
    }

    int dfs(int[][] land, int y, int x, boolean[][] visited, int color) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{y, x});
        visited[y][x] = true;
        land[y][x] = color;

        int areaSize = 0;

        int[] dx = {0, 0, 1, -1}; 
        int[] dy = {1, -1, 0, 0};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curY = current[0];
            int curX = current[1];
            areaSize++;

            for (int d = 0; d < 4; d++) {
                int newY = curY + dy[d];
                int newX = curX + dx[d];

                if (isValid(newX, newY, land) && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    land[newY][newX] = color;
                    stack.push(new int[]{newY, newX});
                }
            }
        }

        return areaSize;
    }

    boolean isValid(int x, int y, int[][] land) {
        return x >= 0 && y >= 0 && x < xLen && y < yLen && land[y][x] == 1;
    }
}
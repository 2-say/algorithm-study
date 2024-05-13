import java.io.*;
import java.util.*;

class Main {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[][] map1;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		map1 = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				if (input[j].equals("R")) {
					map[i][j] = 1;
					map1[i][j]= 1;
				}
				if (input[j].equals("G")) {
					map[i][j] = 2;
					map1[i][j] = 1;
				}
				if (input[j].equals("B")) {
					map[i][j] = 3;
					map1[i][j] = 2;
				}
			}
		}
		int answer = 0;

		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n; j++) {
				if(!visited[i][j]) {
					answer++;
					solve(i, j, map[i][j]);
				}
			}
		}

		int answer1=0;
		visited = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n; j++) {
				if(!visited[i][j]) {
					answer1++;
					solve1(i, j, map1[i][j]);
				}
			}
		}

		System.out.printf("%d %d", answer, answer1);
	}

	static void solve(int x, int y, int color) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		Stack<Point> stac = new Stack<>();
		stac.add(new Point(x, y));
		visited[x][y] = true;

		while (!stac.isEmpty()) {
			Point cur = stac.pop();

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dx[i];
				int nY = cur.y + dy[i];

				if (isValid(nX, nY, color)) {
					visited[nX][nY] = true;
					stac.add(new Point(nX, nY));
				}
			}
		}
	}

	static boolean isValid(int x, int y, int color) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length && !visited[x][y] && map[x][y] == color ;
	}


	static void solve1(int x, int y, int color) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		Stack<Point> stac = new Stack<>();
		stac.add(new Point(x, y));
		visited[x][y] = true;

		while (!stac.isEmpty()) {
			Point cur = stac.pop();

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dx[i];
				int nY = cur.y + dy[i];

				if (isValid1(nX, nY, color)) {
					visited[nX][nY] = true;
					stac.add(new Point(nX, nY));
				}
			}
		}
	}

	static boolean isValid1(int x, int y, int color) {
		return x >= 0 && y >= 0 && x < map1.length && y < map1[0].length && !visited[x][y] && map1[x][y] == color ;
	}
}
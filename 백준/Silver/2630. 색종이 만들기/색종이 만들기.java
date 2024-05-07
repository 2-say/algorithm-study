import java.io.*;
import java.util.*;

class Main {

	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		white = 0;
		blue = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, n);

		System.out.println(white);
		System.out.println(blue);

	}

	static void solve(int x, int y, int size) {
		if(colorCheck(x, y, size)) {
			if(map[x][y] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}

		int newSize = size / 2;

		solve(x, y, newSize);
		solve(x, y + newSize, newSize);
		solve(x + newSize , y , newSize);
		solve(x + newSize , y + newSize, newSize);

	}

	public static boolean colorCheck(int row, int col, int size) {
	
		int color = map[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
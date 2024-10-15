import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		int T = scanner.nextInt();

		for (int i = 0; i < T; i++)
		{
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			int[] time = new int[N + 1];

			boolean[][] matrix = new boolean[N + 1][N + 1];
			int[] link = new int[N + 1];
			
			for (int j = 1; j < N + 1; j++) {
				time[j] = scanner.nextInt();
			}
			
			for (int j = 0; j < K; j++) {
				int X = scanner.nextInt();
				int Y = scanner.nextInt();
				
				matrix[X][Y] = true;
				link[Y]++;
			}

			int W = scanner.nextInt();
			builder.append(calcTopologicalSort(time, matrix, link)[W]).append("\n");
		}
		
		System.out.println(builder.toString());
		scanner.close();
	}

	private static int[] calcTopologicalSort(int[] time, boolean[][] matrix, int[] link) {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[link.length];
		
		for (int i = 1; i < link.length; i++) {

			if (link[i] == 0) {
				result[i] = time[i];
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int prev = queue.poll();

			for (int i = 1; i < link.length; i++) {
				if (matrix[prev][i]) {
					result[i] = Math.max(result[i], result[prev] + time[i]);
					
					--link[i];
                    if (link[i] == 0) queue.add(i);
				}
			}
		}
		return result;
	}
}
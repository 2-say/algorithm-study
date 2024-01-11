import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1976 {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (a[j] == 1) {
                    union(i, j + 1);
                }
            }
        }

        int findarr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean result = true;
        for (int i = 0; i < findarr.length - 1; i++) {
            if (find(findarr[i], findarr[i + 1])) {
                continue;
            } else {
                result = false;
            }
        }
        if (result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void union(int a, int b) {
        int prentA = findPar(a);
        int prentB = findPar(b);
        if (prentA != prentB)
            arr[prentA] = prentB;
    }

    static boolean find(int a, int b) {
        if (findPar(a) == findPar(b)) {
            return true;
        } else
            return false;
    }

    static int findPar(int a) {
        if (arr[a] == a)
            return a;
        else {
            return arr[a] = findPar(arr[a]);
        }
    }
}

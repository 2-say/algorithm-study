import java.io.*;
import java.util.*;

public class Baekjoon14003 {

    static int[] arr;
    static String[][][] memo;
    static List<Long> collect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] indexArr = new int[n + 1];
        String[] input = br.readLine().split(" ");
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        list.add(Integer.MIN_VALUE);

        for (int i = 1; i <= n; i++) {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            if (num > list.get(list.size() - 1)) {
                list.add(num);
                indexArr[i] = list.size() - 1;
            } else {
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) >= num)
                        right = mid;
                    else
                        left = mid + 1;
                }
                list.set(right, num);
                indexArr[i] = right;
            }
        }
        System.out.println(list.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1 + "\n");
        Stack<Integer> stac = new Stack<>();
        int index = list.size() - 1;

        for (int i = n; i > 0; i--) {
            if (indexArr[i] == index) {
                index--;
                stac.push(arr[i]);
            }
        }
        while (!stac.isEmpty()) {
            sb.append(stac.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}

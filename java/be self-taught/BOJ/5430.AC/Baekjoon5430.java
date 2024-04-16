import java.io.*;
import java.util.*;

public class Baekjoon5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            String command = br.readLine();
            int arrC = Integer.parseInt(br.readLine());
            if (arrC == 0) {
                br.readLine();
                String result = null;
                for (int a = 0; a < command.length(); a++) {
                    if (command.charAt(a) == 'D')
                        result = "error";
                }
                if (result != null)
                    sb.append(result).append("\n");
                else
                    sb.append("[]\n");
            } else {
                String listString = br.readLine();
                listString = listString.replace("[", "");
                listString = listString.replace("]", "");
                int[] arr = Arrays.stream(listString.split(",")).mapToInt(Integer::parseInt).toArray();
                sb.append(solve(command, arr)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static String solve(String allCommand, int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        boolean isFront = true;

        for (int i = 0; i < allCommand.length(); i++) {
            if (allCommand.charAt(i) == 'R')
                isFront = (isFront) ? false : true;
            else if (allCommand.charAt(i) == 'D') {
                if (s > e)
                    return "error";
                else if (isFront)
                    s++;
                else
                    e--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isFront) {
            if (s <= e) {
                for (int i = s; i <= e; i++) {
                    sb.append(arr[i] + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
        } else {
            if (s <= e) {
                for (int i = e; i >= s; i--) {
                    sb.append(arr[i] + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
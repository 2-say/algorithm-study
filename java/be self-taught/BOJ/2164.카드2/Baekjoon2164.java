import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList();
        
        for (int i = 1; i <= n; i++)
            list.add(i);

        while (list.size() != 1) {
            list.remove(0);
            int top = list.get(0);
            list.remove(0);
            list.add(top);
        }
        System.out.println(list.get(0));
    }
}

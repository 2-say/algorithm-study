import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<Integer> list = new ArrayList<>();
        List<Integer> yose = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(i + 1);

        int index = m - 1;
        while (!list.isEmpty()) {
            while (index >= list.size()) {
                index -= list.size();
            }
            System.out.println(index);
            yose.add(list.get(index));
            list.remove(index);
            index += (m - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (Integer integer : yose) {
            sb.append(", ").append(integer);
        }
        sb.delete(1, 3);
        sb.append(">");
        System.out.println(sb.toString());
    }
}

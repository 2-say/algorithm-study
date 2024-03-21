import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> sat = new HashSet();
        StringBuilder sb = new StringBuilder();
        List<Integer> add = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            add.add(i);
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            if (command.equals("add")) {
                sat.add(Integer.parseInt(input[1]));
            } else if (command.equals("check")) {
                if (sat.contains(Integer.parseInt(input[1]))) {
                    sb.append("1").append("\n");
                } else
                    sb.append("0").append("\n");
            } else if (command.equals("remove") && sat.contains(Integer.parseInt(input[1]))) {
                sat.remove(Integer.parseInt(input[1]));
            } else if (command.equals("all")) {
                sat = new HashSet();
                sat.addAll(add);
            } else if (command.equals("toggle")) {
                if (sat.contains(Integer.parseInt(input[1]))) {
                    sat.remove(Integer.parseInt(input[1]));
                } else
                    sat.add(Integer.parseInt(input[1]));
            } else if (command.equals("empty")) {
                sat = new HashSet<>();
            }
        }
        System.out.println(sb.toString());

    }
}

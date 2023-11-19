import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Baekjoon2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> sortList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            sortList.add(num);
        }
        sortList.sort(Comparator.naturalOrder());

        System.out.println(sortList.get(8));
        System.out.println(list.indexOf(sortList.get(8))+1);
    }
}

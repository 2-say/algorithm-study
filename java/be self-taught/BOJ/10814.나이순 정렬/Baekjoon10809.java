import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Baekjoon10809 {
    
    static class Info implements Comparable<Info> { 
        String name;
        int age;
        public Info(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(age, o.age);
        }
    }

    public static void main(String[] args)  throws IOException {
        List<Info> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {    
            String[] input = br.readLine().split(" ");
            list.add(new Info(input[1], Integer.parseInt(input[0])));
        }
        Collections.sort(list);

        for (Info info : list) {
            System.out.println(info.age + " " + info.name);
        }
    }
    
}

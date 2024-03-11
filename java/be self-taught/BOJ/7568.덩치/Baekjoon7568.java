import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Baekjoon7568 {

    static class Person {
        int tall;
        int weight;

        public Person(int tall, int weight) {
            this.tall = tall;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            persons[i] = new Person(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != j) && persons[i].tall < persons[j].tall && persons[i].weight < persons[j].weight) {
                    result[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
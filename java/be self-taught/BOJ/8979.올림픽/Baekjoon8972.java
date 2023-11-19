import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon8972 {

    static class Nation implements Comparable<Nation> {
        int gold;
        int silver;
        int bronze;
        int name;
        int rank;

        public Nation(int gold, int silver, int bronze, int name) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.name = name;
        }

        @Override
        public int compareTo(Nation other) {
            if (this.gold != other.gold) {
                return Integer.compare(other.gold, this.gold);
            } else if (this.silver != other.silver) {
                return Integer.compare(other.silver, this.silver); 
            } else {
                return Integer.compare(other.bronze, this.bronze); 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndFind = br.readLine().split(" ");
        int n = Integer.parseInt(nAndFind[0]);
        int findNation = Integer.parseInt(nAndFind[1]);

        Nation[] nations = new Nation[n];

        for (int i = 0; i < n; i++) {
            String[] aStrings = br.readLine().split(" ");

            int name = Integer.parseInt(aStrings[0]);
            int goldNum = Integer.parseInt(aStrings[1]);
            int silverNum = Integer.parseInt(aStrings[2]);
            int bronzeNum = Integer.parseInt(aStrings[3]);
            nations[i] = new Nation(goldNum, silverNum, bronzeNum, name);
        }
        Arrays.sort(nations);
        int rank = 1;
        for (int i = 0; i < nations.length; i++) {
            if (i > 0 && nations[i].compareTo(nations[i - 1]) == 0) {
                nations[i].rank = nations[i - 1].rank;
            } else {
                nations[i].rank = rank;
            }
            rank++;
        }
        for (int i = 0; i < nations.length; i++) {
            if (nations[i].name == findNation) {
                System.out.println(nations[i].rank);
                break;
            }
        }
    }
}

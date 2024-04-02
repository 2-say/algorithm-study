import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Baekjoon2162 {

    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        int number;
        P p1;
        P p2;

        public Line(int number, P p1, P p2) {
            this.number = number;
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    static List<Line> lineList;
    static int[] unionFindArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lineList = new ArrayList<>();
        unionFindArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unionFindArr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            Line line = new Line(i + 1, new P(x, y), new P(x1, y1));
            lineList.add(line);
        }

        
        for (int i = 0; i < lineList.size() - 1; i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                checkTwoLineSameGroup(lineList.get(i), lineList.get(j));
            }
        }
        
        for (int i = 1; i <= n; i++)
            findParent(i);

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (result.containsKey(unionFindArr[i])) {
                result.put(unionFindArr[i], result.get(unionFindArr[i]) + 1);
            } else
                result.put(unionFindArr[i], 1);
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Entry<Integer, Integer> e : result.entrySet()) {
            count++;
            if (e.getValue() > max)
                max = e.getValue();
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void checkTwoLineSameGroup(Line line1, Line line2) {
        long ccw1 = ccw(line1.p1, line1.p2, line2.p1);
        long ccw2 = ccw(line1.p1, line1.p2, line2.p2);
        long ccw3 = ccw(line2.p1, line2.p2, line1.p1);
        long ccw4 = ccw(line2.p1, line2.p2, line1.p2);

        if (checkCCW(ccw1, ccw2, ccw3, ccw4, line1, line2) == 1) {
            union(line1.number, line2.number);
        }
    }

    public static long ccw(P p1, P p2, P p3) {
        long ccw = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y))
                - ((p2.x * p1.y) + (p3.x * p2.y) + (p1.x * p3.y));

        if (ccw > 0)
            return 1;
        else if (ccw < 0)
            return -1;
        else
            return 0;
    }

    public static int checkCCW(long ccw1, long ccw2, long ccw3, long ccw4, Line l1, Line l2) {
        int result = 0;
        boolean check = false;
        // 일직선일 때
        if ((ccw1 * ccw2 == 0) && (ccw3 * ccw4 == 0)) {
            // 일직선인데 겹칠 때
            check = true;
            if (Math.max(l2.p1.x, l2.p2.x) >= Math.min(l1.p1.x, l1.p2.x)
                    && Math.max(l1.p1.x, l1.p2.x) >= Math.min(l2.p1.x, l2.p2.x)
                    && Math.max(l2.p1.y, l2.p2.y) >= Math.min(l1.p1.y, l1.p2.y)
                    && Math.max(l1.p1.y, l1.p2.y) >= Math.min(l2.p1.y, l2.p2.y)) {
                result = 1;
            }
        }
        if ((ccw1 * ccw2) <= 0 && (ccw3 * ccw4) <= 0 && !check)
            result = 1;

        return result;
    }

    public static int findParent(int x) {
        if (unionFindArr[x] == x) {
            return x;
        } else {
            return unionFindArr[x] = findParent(unionFindArr[x]);
        }
    }

    public static void union(int i1, int i2) {
        int pInd = findParent(i1);
        int pInd1 = findParent(i2);

        if (pInd != pInd1)
            unionFindArr[pInd] = pInd1;

    }
}

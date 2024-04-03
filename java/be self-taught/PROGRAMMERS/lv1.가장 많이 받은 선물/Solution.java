import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] giftArr = new int[friends.length][friends.length];
        int[][] giftPoint = new int[friends.length][3];
        int[] result = new int[friends.length];

        for (int i = 0; i < gifts.length; i++) {
            String[] ab = gifts[i].split(" ");
            int findRow = 0;
            int findCol = 0;
            // 찾기
            for (int j = 0; j < friends.length; j++) {
                if (ab[0].equals(friends[j])) {
                    findRow = j;
                }
                if (ab[1].equals(friends[j])) {
                    findCol = j;
                }
            }

            giftArr[findRow][findCol]++;
            giftPoint[findRow][0]++;
            giftPoint[findCol][1]++;
        }
        
        // 선물 지수
        for (int i = 0; i < friends.length; i++) {
            giftPoint[i][2] = giftPoint[i][0] - giftPoint[i][1];
        }

        for (int i = 0; i < friends.length; i++) {

            for (int j = i + 1; j < friends.length; j++) {
                if (giftArr[i][j] < giftArr[j][i]) {
                    result[j]++;
                } else if (giftArr[i][j] > giftArr[j][i]) {
                    result[i]++;
                } else {
                    // 주고 받지 않은 경우
                    if (giftPoint[j][2] > giftPoint[i][2]) {
                        result[j]++;
                    } else if (giftPoint[j][2] < giftPoint[i][2]) {
                        result[i]++;
                    }
                }
            }

        }

        return Arrays.stream(result).max().getAsInt();
    }
}

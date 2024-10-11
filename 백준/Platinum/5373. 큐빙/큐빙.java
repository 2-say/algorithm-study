import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][][] cube;
    static final int UP = 0, DOWN = 1, FRONT = 2, BACK = 3,LEFT = 4, RIGHT = 5;
    static char[] initColor = {'w','y','r','o','g','b'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());


       StringTokenizer st = null;
        //테스트케이스만큼 반복
        for (int i = 0; i < TC; i++) {
            //큐브생성

            cube = initNewCube(initColor);

            int rotateCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < rotateCount; j++) {
                String temp = st.nextToken();
                char targetPlane = temp.charAt(0);
                char rotateDirection = temp.charAt(1);
                rotate(targetPlane, rotateDirection);
            }
            printUpside();
        }
    }

    private static void printUpside() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(cube[UP][j][2-i]);
            }
            System.out.println();
        }
    }

    private static char[][][] initNewCube(char[] colors) {
        int num = colors.length;
        char[][][] tempCube = new  char[num][3][3];

        for(int i=0; i<num; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    tempCube[i][j][k] = colors[i];
                }
            }
        }
        return tempCube;

    }

    private static void rotate(char targetPlane, char rotateDirection) {
        switch (targetPlane){
            //어떤면을 돌린다. 어떤면의 반대편을 제외하고 모두 영향을 받음.
            case 'U':
                alter(UP,LEFT,FRONT,RIGHT,BACK,rotateDirection);
                break;
            case 'D':
                alter(DOWN,BACK,RIGHT,FRONT,LEFT,rotateDirection);
                break;
            case 'F':
                alter(FRONT,UP,LEFT,DOWN,RIGHT,rotateDirection);
                break;
            case 'B':
                alter(BACK,RIGHT,DOWN,LEFT,UP,rotateDirection);
                break;
            case 'L':
                alter(LEFT,FRONT,UP,BACK,DOWN,rotateDirection);
                break;
            case 'R':
                alter(RIGHT,DOWN,BACK,UP,FRONT,rotateDirection);
                break;
            default:
                break;

        }
    }

    private static void alter(int front, int up, int left, int down, int right, char rotateDirection) {
        //해당면과 옆면이 돌아가는것이 다름

        char[][] upSideTemp = new char[3][3];
        char[] sideTemp = new char[3];

        if (rotateDirection == '+') {
            for (int i=0; i<3; ++i)
                for (int j=0; j<3; ++j) {
                    upSideTemp[i][j] = cube[front][2-j][i];
                }
            for (int i=0; i<3; ++i)
                sideTemp[i] = cube[up][i][0];
            for (int i=0; i<3; ++i)
                cube[up][i][0] = cube[left][0][2-i];
            for (int i=0; i<3; ++i)
                cube[left][0][2-i] = cube[down][2][i];
            for (int i=0; i<3; ++i)
                cube[down][2][i] = cube[right][2-i][2];
            for (int i=0; i<3; ++i)
                cube[right][2-i][2] = sideTemp[i];
        }
        else {
            for (int i=0; i<3; ++i)
                for (int j=0; j<3; ++j) {
                    upSideTemp[i][j] = cube[front][j][2-i];
                }
            for (int i=0; i<3; ++i)
                sideTemp[i] = cube[up][i][0];
            for (int i=0; i<3; ++i)
                cube[up][i][0] = cube[right][2-i][2];
            for (int i=0; i<3; ++i)
                cube[right][2-i][2] = cube[down][2][i];
            for (int i=0; i<3; ++i)
                cube[down][2][i] = cube[left][0][2-i];
            for (int i=0; i<3; ++i)
                cube[left][0][2-i] = sideTemp[i];
        }
        cube[front] = upSideTemp;

    }
}
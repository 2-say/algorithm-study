import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static int L;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0 ; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }

        solve();
    }

    static void solve() {

        int answer = 0;

        //행 검사
        for(int i = 0 ; i < N; i++) {

            int flatStack = 1;
            boolean check = true;

            for(int j = 0; j < N-1; j++) {
                if(map[i][j] == map[i][j+1]) flatStack++;

                //내려가는 방향이라면
                else if(map[i][j] == map[i][j+1]+1) {
                    int f = map[i][j+1];
                    boolean a = true;

                    for(int k = j+2; k < (j+1)+L; k++) {
                        if(k >= N || map[i][k] != f) {
                            a = false;
                            break;
                        } 
                    }
                    
                    if(a) {
                        j = (j+L)-1;
                        flatStack = 0;
                    } else {
                        check=false;
                        break;
                    }
                } 
                
                //올라가는 방향이라면
                else if(map[i][j] + 1 == map[i][j+1]) {
                    if(flatStack >= L) {
                        flatStack = 1;
                    } else {
                        check=false;
                        break;
                    }
                } else {
                    check=false;
                    break;
                }
            }

            if(check) {
                //System.out.println("행 = " + i);
                answer++;
            }
        }

        //열 검사
        for(int i = 0 ; i < N; i++) {
            int flatStack = 1;
            boolean check = true;

            for(int j = 0; j < N-1; j++) {
                if(map[j][i] == map[j+1][i]) flatStack++;

                //내려가는 방향이라면
                else if(map[j][i] == map[j+1][i]+1) {
                    flatStack = 1;
                    int f = map[j+1][i];
                    boolean a = true;
            
                    for(int k = j+2; k < (j+1)+L; k++) {
                        if(k >= N || map[k][i] != f) {
                            a = false;
                            break;
                        } else if(map[k][i] == f) {
                            flatStack++;
                        }
                    }
                    
                    if(a) {
                        j = (j+L)-1;
                        flatStack=0;
                    } else {
                        check=false;
                        break;
                    }
                } 
                
                //올라가는 방향이라면
                else if(map[j][i] + 1 == map[j+1][i]) {
                    if(flatStack >= L) {
                        flatStack = 1;
                    } else {
                        check=false;
                        break;
                    }
                } else {
                    check=false;
                    break;
                }
            }
            if(check) {
                //System.out.println("열 = " + i);
                answer++;
            }
        }



        System.out.println(answer);


    }


}
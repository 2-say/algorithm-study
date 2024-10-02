import java.io.*;
import java.util.*;

class Main {

    static int answer;
    static int[][] ability;
    static boolean[] visited;
    static int N;

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visited = new boolean[N];

        for(int i = 0 ; i < N; i++) {
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(answer);
    }



    static void dfs(int depth, int start) {
        if(depth == N/2) {
            //2명 선택 계산
            int a = abilityCal();
            if(answer > a) answer = a;
            return;
        }

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }



    static int abilityCal() {
        int aTeamS = 0;
        int bTeamS = 0;
        List<Integer> aTeam = new ArrayList<>();
        List<Integer> bTeam = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if(visited[i]) aTeam.add(i);
            else bTeam.add(i);
        }

        for(int i : aTeam) {
            for(int j: aTeam) {
                if(i == j) continue;
                aTeamS += ability[i][j];
            }        
        }


        for(int i : bTeam) {
            for(int j: bTeam) {
                if(i == j) continue;
                bTeamS += ability[i][j];
            }        
        }

        return Math.abs(aTeamS - bTeamS);
    }
}

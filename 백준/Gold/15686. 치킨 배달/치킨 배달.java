import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static P[] store;
    static List<P> ans;
    static List<P> house;
    static int answer;

    static class P {
        int num;
        int x;
        int y;

        P(int num ,int x, int y) {
            this.num =  num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<P> temp = new ArrayList<>();
        house = new ArrayList<>();

        int num = 0;
        for(int i = 0 ; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N; j++) {
                if(Integer.parseInt(input[j]) == 2) temp.add(new P(num++,i,j));
                else if(Integer.parseInt(input[j]) == 1) house.add(new P(0, i, j));
            }
        }
        
        int arrListS = temp.size();
        store = temp.toArray(new P[arrListS]);
        ans = new ArrayList<>();
        visited = new boolean[arrListS+1];
        answer = Integer.MAX_VALUE;

        //M개의 치킨집만 고른다.
        dfs(0, 0);
        System.out.println(answer);
    }

    //백트래킹
    static void dfs(int idx, int count) {
        if(count == M) {
            int val = 0;
            for(P p : house) {
                val += cal(p.x,p.y, ans);
            }

            //정답 기록
            if(answer > val) answer = val;
        } else {
            for(int i = idx ; i < store.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    ans.add(store[i]);

                    dfs(i+1, count+1);

                    ans.remove(store[i]);
                    visited[i] = false;
                }
            }
        }
    }

    static int cal(int x, int y, List<P> ans) {
        int val = Integer.MAX_VALUE;
        for(P p: ans) {
            val = Math.min(Math.abs(x - p.x) + Math.abs(y - p.y), val);
        }
        return val;
    }
} 
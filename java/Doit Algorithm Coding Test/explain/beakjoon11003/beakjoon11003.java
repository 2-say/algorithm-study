package explain.beakjoon11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class beakjoon11003{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력 버퍼에 넣고 한번에 출력하기 위해 BufferWriter 사용 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arg1  = br.readLine().split(" "); //12 3 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(arg1[0]);  //12
        int L  = Integer.parseInt(arg1[1]);  //3
        Deque<int[]> myDeque = new ArrayDeque<>();

		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken()); //입력값을 받는다. 1 5 2 3 6 2 3 7 3 5 2 6 
            //만약 [(1,0) (5,1)] 값이 들어와 있고 (2,2)가 들어오면 비교한다. 
			while(!myDeque.isEmpty() && myDeque.peekLast()[0] > now){ 
                myDeque.pollLast(); //뒤에서 제거
            }
            myDeque.offer(new int[] {now,i}); //뒤에다 입력
            if(myDeque.peekFirst()[1] <= (i-L)){
                myDeque.removeFirst();
            }
            bw.write(myDeque.peekFirst()[0]+" ");
        }
        bw.flush();
        bw.close();
    }
}
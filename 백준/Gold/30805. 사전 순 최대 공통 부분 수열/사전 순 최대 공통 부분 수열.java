import java.io.*;
import java.util.*;

class Main {

    static class E implements Comparable<E> {
        int v;
        int idx;

        E(int v, int idx) {
            this.v = v; 
            this.idx = idx;
        }

        @Override
        public int compareTo(E o) {
            if(o.v == v) return Integer.compare(idx, o.idx);
            else return o.v - this.v;
        }

        @Override
        public String toString() {
            return "v = " + v + " idx = " + idx;
        }
    }

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<E> aQue = new ArrayList();
        List<E> bQue = new ArrayList();

        int A = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        for(int i = 0; i < A; i++)
            aQue.add(new E(Integer.parseInt(in[i]),i));
        Collections.sort(aQue);
        int B = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        for(int i = 0; i < B; i++)
            bQue.add(new E(Integer.parseInt(in[i]),i));
        Collections.sort(bQue);

        StringBuilder sb = new StringBuilder();
        int lastIdx1 = -1, lastIdx2 = -1;
        int listIdx1 = 0, listIdx2 = 0;
        int count = 0;
        
        while(listIdx1 < A && listIdx2 < B) {
            E e1 = aQue.get(listIdx1);
            E e2 = bQue.get(listIdx2);

            if(e1.v == e2.v) {
                if(lastIdx1 < e1.idx && lastIdx2 < e2.idx) {
                    lastIdx1 = e1.idx;
                    lastIdx2 = e2.idx;
                    count++;
                    sb.append(e1.v).append(" ");
                } else if(lastIdx1 >= e1.idx) {
                    listIdx1++;
                } else if(lastIdx2 >= e2.idx) {
                    listIdx2++;
                }
            } else if(e1.v > e2.v) { 
                listIdx1++;    
            } else {
                listIdx2++;
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

}
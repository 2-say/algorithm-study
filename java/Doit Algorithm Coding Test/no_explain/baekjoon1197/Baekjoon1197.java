import java.io.*;
import java.util.*;

public class Baekjoon1197 {
	static Queue<Node> que;
	static int[] unionArr;
	
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int cost;
		Node(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		que = new PriorityQueue<>();
		unionArr = new int[v];
		
		//유니온 파인드 번호 초기화
		for(int i=0; i<v; i++) {
			unionArr[i]=i;
		}
		
		//입력
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int edge = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			que.add(new Node(s, edge, cost));
		}
		
		System.out.println(kruscal(v));
 	}
	
	static int kruscal(int v) {
		int result = 0;
		
		int round = 0;
		while(!que.isEmpty()) {
			Node cur = que.poll();
			if(findParent(cur.s) != findParent(cur.e)) {
				result += cur.cost;
				union(cur.s, cur.e);
				round++;
			}
			
		}
		
		return result;
	}

	static void union(int a, int b) {
		int pA = findParent(a); 
		int pB = findParent(b);
		
		if(pA != pB)
			unionArr[pB] = pA;
	}
	
	static int findParent(int i) {
		if(unionArr[i] == i)
			return i;
		else
			return  unionArr[i] = findParent(unionArr[i]);
		
	}
}

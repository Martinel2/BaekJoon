package solved;

import java.io.*;
import java.util.*;

public class Main {

	static class P implements Comparable<P>{
		int a;
		int b;
		
		P(int a, int b){
			this.a=a;
			this.b=b;
		}
		
		@Override
		public int compareTo(P o) {
			return (this.a-this.b)-(o.a-o.b);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 같은 물건을 두 상점에서 판매
		// a에서 A개 b에서 B개 사서 최소비용으로 물건 구매
		//그리디
		//예외) 1 1 1
		// 	  2 1
		//    999 2
		// ans = 4, but greedy is 1000
		
		// 두 가게의 가격의 차이가 적은것 부터 a가게에서 구매
		//    1 1 1
		// 	  2 1  -> 1
		//    999 2 -> 997
		// ans = 4
		
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		long sum = 0;
		PriorityQueue<P> pq = new PriorityQueue<>();
		
		for(int i=0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			
			int ap = Integer.parseInt(st.nextToken());
			int bp = Integer.parseInt(st.nextToken());
			
			pq.add(new P(ap,bp));
		}
		
		while(a-->0) {
			P p = pq.poll();
			sum += p.a;
		}
		while(b-->0) {
			P p = pq.poll();
			sum += p.b;
		}
		
		System.out.println(sum);
		
	}
}
package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main{
	
	static int[] A;
	
	static class E implements Comparable<E>{
		int str;
		int end;
		int weight;
		
		E(int str, int end, int weight){
			this.str = str;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(E o) {
			return this.weight - o.weight;
		}
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		A[y] = x;
	}
	
	static int find(int x) {
		if(A[x] == x) return x;
		else {
			A[x] = find(A[x]);
			return A[x];
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//그래프
		//최소 신장 트리
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new int[n];
		
		PriorityQueue<E> pq = new PriorityQueue<>();
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			A[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new E(a,b,w));
		}
		
		int ans = 0;
		while(!pq.isEmpty()) {
			E e = pq.poll();
			
			//둘 사이 경로가 없으면 경로를 추가한다
			if(find(e.str) != find(e.end)) {
				union(e.str,e.end);
				ans += e.weight;
				
				if(max < e.weight)
					max = e.weight;
			}
		}
		
		ans -= max;
		
		System.out.println(ans);
	}
}
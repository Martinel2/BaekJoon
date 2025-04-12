package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static class E implements Comparable<E>{
		int a,b,w;
		
		E(int a, int b, int w){
			this.a=a;
			this.b=b;
			this.w=w;
		}
		
		@Override
		public int compareTo(E o) {
			return this.w-o.w;
		}
	}
	
	static int[] p;
	
	static int[] make(int n) {
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) arr[i]=i;
		return arr;
	}
	
	
	static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
	
	static int kruskal (int n, PriorityQueue<E> e) {
		p = make(n);
		
		int sum =0;
		int cnt =0;
		
		while(!e.isEmpty()) {
			E edge = e.remove();
			if(find(edge.a) == find(edge.b)) continue;
			
			union(edge.a,edge.b);
			sum += edge.w;
			cnt++;
			
			if(cnt == n-1) return sum;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			int max = 0;
			
			PriorityQueue<E> e = new PriorityQueue<>();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				e.add(new E(a,b,w));
				max += w;
			}
			
			int min = kruskal(n,e);
			sb.append(max-min).append('\n');
		}
		System.out.println(sb);
	}
}
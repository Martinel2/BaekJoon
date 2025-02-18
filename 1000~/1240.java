package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {		

	static class N{
		int next;
		int weight;
		
		N(int next, int weight){
			this.next=next;
			this.weight=weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<N>[] link = new ArrayList[n+1];
		
		for(int i =1; i<=n; i++) {
			link[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			link[a].add(new N(b,w));
			link[b].add(new N(a,w));
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[n+1];
			Queue<N> q = new LinkedList<>();
			
			visit[str] = true;
			q.add(new N(str,0));
			int ans = 0;
			while(!q.isEmpty()) {
				N now = q.poll();
				
				for(N next: link[now.next]) {
					if(!visit[next.next]) {
						if(next.next == end) {
							ans = now.weight+next.weight;
							break;
						}
						visit[next.next]=true;
						q.add(new N(next.next,now.weight+next.weight));
					}
				}
				if(ans !=0) break;
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}	
}
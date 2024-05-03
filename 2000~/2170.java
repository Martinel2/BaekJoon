package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class P implements Comparable<P>{
		int x;
		int y;
		
		P(int x, int y){
			this.x=x;
			this.y=y;
		}
		
		@Override
		public int compareTo(P o) {
			if(this.x==o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<P> pq = new PriorityQueue<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new P(x,y));
		}
		
		int saveY = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			P e = pq.poll();
			int nx = Math.max(e.x,saveY);
			int ny = e.y;
			
			ans += ny - nx;
			saveY = Math.max(saveY,ny);
			System.out.println(nx+" "+ny);
		}
		
		System.out.println(ans);
	}
}
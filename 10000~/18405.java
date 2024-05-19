package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class P implements  Comparable<P>{
		int x;
		int y;
		int w;
		
		P(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(P o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		PriorityQueue<P> pq = new PriorityQueue<>();
		Queue<P> q = new LinkedList<>();
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) {
					pq.add(new P(i,j,arr[i][j]));
				}
			}
		}
		while(!pq.isEmpty()) {
			q.add(pq.poll());
		}
		
		st = new StringTokenizer(br.readLine());
		int s,x,y;
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken())-1;
		y = Integer.parseInt(st.nextToken())-1;
		
		for(int j = 0; j<s; j++) {
			int len =q.size();
			for(int size = 0; size<len; size++) {
				P p = q.poll();					
				for(int m=0; m<4; m++) {
					int nx = p.x + dx[m];
					int ny = p.y + dy[m];
					
					if((0 <= nx && nx <n) && (0 <= ny && ny < n)
							&& arr[nx][ny] == 0) {
							
						arr[nx][ny] = p.w;
						q.add(new P(nx,ny,p.w));
					}
				}
			}
		}
		System.out.println(arr[x][y]);		
	}
}
package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class M implements Comparable<M>{
		int x;
		int y;
		int weight;
		
		M(int x, int y, int weight){
			this.x=x;
			this.y=y;
			this.weight=weight;
		}

		@Override
		public int compareTo(M o) {
			return this.weight-o.weight;
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n;
        int cnt = 1;
        while((n = Integer.parseInt(br.readLine())) != 0) {
        	int[][] arr = new int[n][n];
        	int[][] cost = new int[n][n];
        	int[] dx = {1,0,-1,0};
        	int[] dy = {0,1,0,-1};
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<n; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			cost[i][j] = Integer.MAX_VALUE;
        		}
        	}
        	
        	cost[0][0] = arr[0][0];
        	PriorityQueue<M> pq = new PriorityQueue<>();
        	
        	pq.add(new M(0, 0, arr[0][0]));
        	while(!pq.isEmpty()) {
        		M now = pq.poll();
        		
        		if(cost[now.x][now.y] < now.weight) continue;
        		
        		for(int i=0; i<4; i++) {
        			int nx = now.x+dx[i];
        			int ny = now.y+dy[i];
        			if(0<= nx && nx < n && 0<= ny && ny < n) {
	        			int c = now.weight+arr[nx][ny];
	        			if(c < cost[nx][ny]) {
	        				cost[nx][ny] = c;
	        				pq.add(new M(nx,ny,c));
	        			}
        			}
        		}
        	}
        	sb.append("Problem "+ cnt+": ").append(cost[n-1][n-1]).append('\n');
        	cnt++;
        }
        System.out.println(sb);
    }
}

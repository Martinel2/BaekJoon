package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static class P implements Comparable<P>{
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
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        char[][] arr = new char[n][m];
        boolean[][] visit = new boolean[n][m];
        
        for(int i = 0; i<n; i++) {
        	arr[i] = br.readLine().toCharArray();
        }
        
        Queue<P> q = new PriorityQueue<>();
        q.add(new P(0,0,0));
        visit[0][0] = true;
        
        int ans = 0;
        while(!q.isEmpty()) {
        	P p = q.poll();
        	
        	int x = p.x;
        	int y = p.y;
        	int w = p.w;
        	
        	//System.out.println(x+" "+y+" "+w);
        	if(x == n-1 && y == m-1) {
        		ans = w;
        		break;
        	}
        	
        	for(int i = 0; i<4; i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		
        		if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1) continue;
        		
        		if(visit[nx][ny]) continue;
        		
        		visit[nx][ny] = true;
        		if(arr[nx][ny] == '0') {
        			q.add(new P(nx, ny, w));
        		}
        		else
        			q.add(new P(nx, ny, w+1));
        		
        	}
        }
        System.out.println(ans);
        
    }
}
package island;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class D {
		int x;
		int y;
		
		D(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int n,m;
	static boolean check(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		char[][] map = new char[n][m];
		Queue<D> q = new LinkedList<>();
		
		int minX,maxX,minY,maxY;
		minX = 11;
		maxX = 0;
		minY = 11;
		maxY = 0;
		
		for(int i = 0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 'X')
					q.add(new D(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			D d = q.poll();
			int cnt = 0;
			for(int i = 0; i<4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				
				if(check(nx,ny) && map[nx][ny] == '.')
					cnt++;
				else if(!check(nx,ny))
					cnt++;
			}
			//System.out.println(cnt);
			if(cnt >= 3) {
				map[d.x][d.y] = 'a';
			}
			else {
				if(minX > d.x)
					minX = d.x;
				if(maxX < d.x)
					maxX = d.x;
				if(minY > d.y)
					minY = d.y;
				if(maxY < d.y)
					maxY = d.y;
			}
		}
		//System.out.println(minX + " "+maxX + " "+minY + " "+maxY);
		for(int i = minX; i<=maxX; i++) {
			for(int j = minY; j<=maxY; j++) {
				if(map[i][j] == 'a')
					map[i][j] = '.';
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}

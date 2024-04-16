package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visit;
	static char[][] map;
	static int r,c,k;
	static int ans = 0;
	
	static void backtracking(int x,int y, int sum)
	{
		//System.out.println(x+" "+y+" "+sum);
		if(sum == k) {
			if(x==0 && y ==c-1) ans++;
			return;
		}
		for(int i = 0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if((0<= nx && nx < r) && (0<= ny && ny < c) 
					&& !visit[nx][ny] && map[nx][ny] !='T') {
				visit[nx][ny] = true;
				backtracking(nx,ny,sum+1);
				visit[nx][ny] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visit = new boolean[r][c];
		
		for(int i = 0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit[r-1][0] = true;
		backtracking(r-1,0,1);
		System.out.println(ans);
   }
}
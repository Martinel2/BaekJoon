package friend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static char[][] board;
	static int n,m;
	static boolean[][] visit;
	static int cnt = 0;
	
	static boolean check(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m);
	}
	
	static void dfs(int x, int y) {
		if(board[x][y] == 'P')
			cnt++;
		
		visit[x][y] = true;
		int nx,ny;
		for(int i = 0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(check(nx,ny) && board[nx][ny] != 'X' && !visit[nx][ny])
				dfs(nx,ny);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		visit = new boolean[n][m];
		
		int x=0,y=0;
		for(int i = 0; i<n; i++) {
			board[i] = br.readLine().toCharArray();
			for(int j = 0; j<m; j++) {
				if(board[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		dfs(x,y);
		
		if(cnt != 0)
			System.out.println(cnt);
		else
			System.out.println("TT");
	}
}

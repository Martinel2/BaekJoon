package invade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][] board;
	static int n,m;
	static boolean[][] visit;
	static boolean clear = false;
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		if(x == n-1) {
			clear = true;
			return;
		}
		else {
			int nx,ny;
			for(int i = 0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(check(nx,ny) && board[nx][ny] == 0 && !visit[nx][ny])
					dfs(nx,ny);
			}
		}
	}
	
	static boolean check(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i<m; i++) {
			if(clear)
				break;
			if(board[0][i] == 0 && !visit[0][i])
				dfs(0,i);
		}
		
		String ans = clear ? "YES" : "NO";
		System.out.println(ans);
	}
}

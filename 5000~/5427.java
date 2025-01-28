package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class F{
	int x;
	int y;
	
	public F(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n,m;
	static char[][] board;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean noOut(int x, int y) {
		return ((0<=x && x<n) && (0<=y && y<m));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			int strx=0;
			int stry=0;
			
			board = new char[n][m];
			Queue<F> fire = new LinkedList<>();
			Queue<F> fire2 = new LinkedList<>();
			
			for(int i = 0; i<n; i++) {
				board[i] = br.readLine().toCharArray();
				for(int j=0; j<m; j++) {
					if(board[i][j] == '@') {
						strx=i;
						stry=j;
						board[i][j] = '.';
					}
					else if(board[i][j] == '*') fire.add(new F(i,j));
				}
			}
			
			Queue<F> user = new LinkedList<>();
			Queue<F> user2 = new LinkedList<>();
			
			boolean clear = false;
			int cnt = 0;
			boolean[][] visit = new boolean[n][m];
			user.add(new F(strx,stry));
			while((!user.isEmpty() || !user2.isEmpty()) && !clear) {

				if(cnt%2 == 0) {
					while(!fire.isEmpty()) {
						F f = fire.poll();
						for(int i=0; i<4; i++) {
							int nx = f.x+dx[i];
							int ny = f.y+dy[i];
							if(noOut(nx,ny) && board[nx][ny] == '.') {
								fire2.add(new F(nx,ny));
								board[nx][ny] = '*';
							}
						}
					}
				}
				else {
					while(!fire2.isEmpty()) {
						F f = fire2.poll();
						for(int i=0; i<4; i++) {
							int nx = f.x+dx[i];
							int ny = f.y+dy[i];
							if(noOut(nx,ny) && board[nx][ny] == '.') {
								fire.add(new F(nx,ny));
								board[nx][ny] = '*';
							}
						}
					}
				}
				if(cnt%2 == 0) {
					while(!user.isEmpty()) {
						F now = user.poll();
						int x = now.x;
						int y = now.y;
						for(int i=0; i<4; i++) {
							int nx = x+dx[i];
							int ny = y+dy[i];
							//System.out.println(nx+" "+ny + " "+cnt);
							if(!noOut(nx,ny)) {
								clear = true;
								break;
							}
							else if(!visit[nx][ny] && board[nx][ny] == '.') {
								user2.add(new F(nx,ny));
								visit[nx][ny] = true;
							}
						}
					}
				}
				else {
					while(!user2.isEmpty()) {
						F now = user2.poll();
						int x = now.x;
						int y = now.y;
						for(int i=0; i<4; i++) {
							int nx = x+dx[i];
							int ny = y+dy[i];
							//System.out.println(nx+" "+ny + " "+cnt);
							if(!noOut(nx,ny)) {
								clear = true;
								break;
							}
							else if(!visit[nx][ny] && board[nx][ny] == '.') {
								user.add(new F(nx,ny));
								visit[nx][ny] = true;
							}
						}
					}
				}
				cnt++;
			}
			if(clear) sb.append(cnt).append('\n');
			else sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
	}
}

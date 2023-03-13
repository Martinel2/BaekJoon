import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class M{
		int x,y,cnt;
		boolean crash = true;
		
		M(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		M(int x, int y, int cnt, boolean crash){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.crash = crash;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<M> Q = new LinkedList<>(); 
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = -1;
		int[][] board = new int[N][M];
		boolean[][][] visit = new boolean[2][N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
		Q.add(new M(0,0,1));
		visit[0][0][0] = true;
		while(!Q.isEmpty()) {
			M cur = Q.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				ans = cur.cnt;
				break;
			}
			for(int i = 0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				int cnt = cur.cnt;
				boolean c = cur.crash;
				if( (0 <= nx && nx < N) && (0 <= ny && ny < M)) {
					if(c && !visit[0][nx][ny]) {
						if(board[nx][ny] == 0) {
							visit[0][nx][ny] = true;
							Q.add(new M(nx,ny,cnt+1,c));
						}
						else if(board[nx][ny] == 1 && c){
							visit[1][nx][ny] = true;
							Q.add(new M(nx,ny,cnt+1,!c));
						}
					}
					else if(!c && !visit[1][nx][ny]){
						if(board[nx][ny] == 0) {
							visit[1][nx][ny] = true;
							Q.add(new M(nx,ny,cnt+1,c));
						}
						else if(board[nx][ny] == 1 && c){
							visit[1][nx][ny] = true;
							Q.add(new M(nx,ny,cnt+1,!c));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}

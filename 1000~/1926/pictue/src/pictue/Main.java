package pictue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] board;
	static boolean[][] visit;
	
	static int dfs(int x, int y) {
		int size = 1;
		visit[x][y] = true;
		if(x+1 < N && board[x+1][y] == 1 && !visit[x+1][y])
			size += dfs(x+1,y);
		if(y+1 < M && board[x][y+1] == 1 && !visit[x][y+1])
			size += dfs(x,y+1);
		return size;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visit = new boolean[N][M];
		int cnt = 0;
		int max = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] == 1 && !visit[i][j]) {
					cnt++;
					max = Math.max(max , dfs(i, j));
				}
			}
		}
		System.out.println(cnt+"\n"+max);
	}
}

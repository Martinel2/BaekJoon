import java.io.*;
import java.util.*;

//1890 มกวม
public class Main {
	
	static int N;
	static int[][] board;
	static boolean[][] visit;
	static long cnt = 0;
	
	static void dfs(int x, int y) {
		if(x == N-1 && y == N-1) {
			cnt++;
			return;
		}
		visit[x][y] = true;
		int move = board[x][y];
		if(y+move < N && !visit[x][y+move])
			dfs(x,y+move);
		if(x+move < N && !visit[x+move][y])
			dfs(x+move,y);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visit = new boolean[N][N];
		for(int  i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(cnt);
	}
}
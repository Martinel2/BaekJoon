import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	
	static char check(char[][] board, int x, int y) {
		int cnt = 0;
		for(int i = x; i<x+3; i++) {
			if(i < 0 || i >= N)
				continue;
			for(int j = y; j<y+3; j++) {
				if(j < 0 || j >= N)
					continue;
				
				if(board[i][j] == '*')
					cnt++;
			}
		}
		
		return Integer.toString(cnt).charAt(0);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		char[][] board = new char[N][N];
		
		char[][] ans = new char[N][N];
		
		for(int i = 0; i<N; i++)
			board[i] = br.readLine().toCharArray();
		
		
		boolean bomb = false;
		for(int i = 0; i<N; i++) {
			ans[i] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++) {
				if(ans[i][j] == 'x') {
					if(board[i][j] == '*') {
						ans[i][j] = '*';
						bomb = true;
					}
					else
						ans[i][j] = check(board,i-1,j-1);
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(bomb) {
					if(board[i][j] == '*') 
						ans[i][j] = '*';
				}
				sb.append(ans[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);	
	}
}

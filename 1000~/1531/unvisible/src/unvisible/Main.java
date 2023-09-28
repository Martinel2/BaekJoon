package unvisible;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[100][100];
		int N,M;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1,x2,y1,y2;
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j<=x2; j++) {
				for(int k = y1; k<=y2; k++) {
					board[j][k]++;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(board[i][j] > M)
					ans++;
			}
		}
		
		System.out.println(ans);
	}
}

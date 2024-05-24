package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//1915
public class Main {
	
	static int n;
	static int[][] dp;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[]dy = {0,1,0,-1};
	
	static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		dp[x][y] = 1;
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if((0<=nx && nx<n) && (0<=ny && ny<n)
					&& (map[x][y] < map[nx][ny])) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max);
	}
}
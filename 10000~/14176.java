package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[][] visit;
	static int n,m;
	
	static int dx[] = {1,0,-1,0, 1,-1,1,-1};
	static int dy[] = {0,1,0,-1, 1,-1,-1,1};;
	
	static void dfs(int x, int y){
		visit[x][y] = true;
		for(int i = 0 ; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if((0<=nx && nx < n) && (0<=ny && ny < m) 
					&& arr[nx][ny] == 1 && !visit[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					ans++;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(ans);
	}
}
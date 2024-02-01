package war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] arr;
	static boolean[][] visit;
	static int n,m;
	static int cnt = 0;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static boolean check(int x, int y) {
		return ( 0<=x && x<m) && (0<=y && y<n);
	}
	
	static void dfs(int x, int y) {
		char c = arr[x][y];
		for(int i = 0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if(check(nx,ny) && !visit[nx][ny] && c==arr[nx][ny]) {
				visit[nx][ny] = true;
				cnt++;
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[m][n];
		visit = new boolean[m][n];
		int w = 0;
		int b = 0;
		
		for(int i = 0;i<m; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(!visit[i][j]) {
					cnt = 1;
					visit[i][j] = true;
					if(arr[i][j] == 'W') {
						dfs(i,j);
						w += Math.pow(cnt, 2);
					}
					else {
						dfs(i,j);
						b += Math.pow(cnt, 2);	
					}
				}
			}
		}
		
		System.out.println(w + " " + b);
	}
}

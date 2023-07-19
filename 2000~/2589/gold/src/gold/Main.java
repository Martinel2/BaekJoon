package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static char[][] map;
	static int[][] dis;
 	static boolean[][] visit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	
	static void dfs(int x, int y, int cnt) {
		if(dis[x][y] == 0 || dis[x][y] > cnt) {
			dis[x][y] = cnt;
		}
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y+ dy[i];
			
			if( (0 <= nx && nx < N) && (0 <= ny && ny < M) ) {
				if(!visit[nx][ny] && map[nx][ny] == 'L') {
					visit[nx][ny] = true;
					dfs(nx,ny,cnt+1);
					visit[nx][ny] = false;
				}
			}
		}
	}
	
	static int findMax() {
		int max = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				max = Math.max(dis[i][j], max);
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new boolean[N][M];
		int max = 0;
		
		for(int i = 0; i<N; i++) {
			String s= br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 'L') {
					dis = new int[N][M];
					visit[i][j] = true;
					dfs(i,j, 0);
					visit[i][j] = false;
					max = Math.max(findMax(),max);
				}
			}
		}
		
		System.out.println(max);
	}
}

/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
 */

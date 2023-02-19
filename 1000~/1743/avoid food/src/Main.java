import java.io.*;
import java.util.*;

//1743 음식물피하기
public class Main {
	
	static int N,M;
	static boolean[][] visit;
	static int[][] road;
	static int max = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int size = 0;
	static void dfs(int x, int y) {
		size++;
		visit[x][y] = true;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if( (0<= nx && nx < N) && (0<= ny && ny < M) 
					&& !visit[nx][ny] && road[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		road = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			road[x][y] = 1;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(road[i][j] == 1 && !visit[i][j]) {
					size = 0;
					dfs(i,j);
					if(max < size)
						max = size;
				}
			}
		}
		System.out.println(max);
	}
}
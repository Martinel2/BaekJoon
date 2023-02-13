import java.io.*;
import java.util.*;


//2583 영역구하기
public class Main {
	
	static int M,N,K;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] area;
	static boolean[][] visit;
	static int size = 0;
	
	static void dfs(int curx, int cury) {
		visit[curx][cury] = true;
		for(int i = 0; i<4; i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if( (0<=nx && nx < N) && (0<=ny && ny < M)  
					&& !visit[nx][ny] && area[nx][ny] != 1) {
				size++;
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		area = new int[N][M];
		visit = new boolean[N][M];
		int cnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int k = 0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i<x2; i++) {
				for(int j = y1; j<y2; j++) {
					area[i][j] = 1;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(!visit[i][j] && area[i][j] != 1) {
					size = 1;
					dfs(i,j);
					pq.add(size);
					cnt++;
				}
			}
		}
		sb.append(cnt).append("\n");
		for(int val : pq) {
			sb.append(val).append(" ");
		}
		System.out.print(sb);
	}
}

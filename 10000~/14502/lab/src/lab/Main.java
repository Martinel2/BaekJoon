package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int dfs(int x, int y) {
		int size = 1;
		visit[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
				if(!visit[nx][ny] && (board[nx][ny] == 2 || board[nx][ny] == 0)) {
					size += dfs(nx, ny);
				}
			}
		}
		
		return size;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		int max = 0;
		int wall = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1)
					wall++;
			}
		}

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 1; //벽 세우기

					for(int k = 1; i+((j+k)/M) < N; k++) {
						int x = i + (j+k)/M;
						int y = (j+k)%M;
						if(board[x][y] == 0) {
							board[x][y] = 1;
				
							//마지막 벽 세우기
							for(int l = 1; x+((y+l)/M) < N; l++) {
								int mx = x + (y+l)/M;
								int my = (y+l)%M;
								if(board[mx][my] == 0) {
									board[mx][my] = 1;
									//System.out.println("(" + i + " "+ j+ "), " + "(" + (x) + " "+ y+ "), "+ "(" + (mx) + " "+ my+ ")");
									//바이러스 퍼트리기
									visit = new boolean[N][M];
									int m = N*M -(wall+3);
									int virus = 0;
									/*
									for(int bi = 0; bi<N; bi++) {
										for(int bj = 0; bj<M; bj++) {
											System.out.print(board[bi][bj] + " ");
										}
										System.out.println();
									}
									*/
									for(int bi = 0; bi<N; bi++) {
										for(int bj = 0; bj<M; bj++) {
											if(board[bi][bj] == 2 && !visit[bi][bj])
												virus += dfs(bi, bj);
										}
									}
									//System.out.println(virus);
									//최대크기 검사
									max = Math.max(m-virus, max);
									
									//벽 다시 제거하기
									board[mx][my] = 0;
								}
							}
							//벽 다시 제거하기
							board[x][y] = 0;
						}
					}
					board[i][j] = 0;
				}
			}
		}
		
		System.out.println(max);
	}
}

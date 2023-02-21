import java.io.*;
import java.util.*;

//27314 러키*한별
public class Main {
	
	static class xy{
		int x;
		int y;
		
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int N,M;
		int max = 0;
		Queue<xy> q = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		xy[] people = new xy[100];
		xy[] exit = new xy[100];
		int pidx = 0;
		int eidx = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[i] = st.nextToken().toCharArray();
			for(int j = 0; j<M; j++) {
				//출구
				if(board[i][j] == '#') {
					exit[eidx] = new xy(i,j);
					eidx++;
				}
				else if(board[i][j] == 'P') {
					people[pidx] = new xy(i,j);
					pidx++;
				}
				else if(board[i][j] == 'H') {
					q.add(new xy(i,j));
					visit[i][j] = true;
				}
			}
		}
		
		long[][][] p_map = new long[pidx][N][M];
		long[][] h_map = new long[N][M];
		//한별이 bfs
		int E = eidx;
		//더이상 갈수있는곳이 없거나 출구를 모두 방문시 종료
		while(!q.isEmpty() && E>0) {
			xy tmp = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) 
						&& !visit[nx][ny] && board[nx][ny] != 'X') {
					if(board[nx][ny] == '#') {
						E--;
					}
					visit[nx][ny] = true;
					h_map[nx][ny] = h_map[tmp.x][tmp.y]+1;
					q.add(new xy(nx,ny));
				}
			}	
		}
		q.clear();
		//사람 bfs
		for(int i = 0; i<pidx; i++) {
			visit = new boolean[N][M];
			int px = people[i].x;
			int py = people[i].y;
			E = eidx;
			q.add(new xy(px,py));
			visit[px][py] = true;
			//더이상 갈수있는곳이 없거나 출구를 모두 방문시 종료
			while(!q.isEmpty() && E>0) {
				xy tmp = q.poll();
				for(int j = 0; j<4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					if((0 <= nx && nx < N) && (0 <= ny && ny < M) 
							&& !visit[nx][ny] && board[nx][ny] != 'X') {
						if(board[nx][ny] == '#') {
							E--;
						}
						visit[nx][ny] = true;
						p_map[i][nx][ny] = p_map[i][tmp.x][tmp.y]+1;
						q.add(new xy(nx,ny));
					}
				}
			}
			q.clear();
		}
		
		
		
		for(int i = 0; i<eidx; i++) {
			int gift = 0;
			int ex = exit[i].x;
			int ey = exit[i].y;
			long han = h_map[ex][ey];
			if(han == 0)
				continue;
			else {
				for(int j = 0; j<pidx; j++) {
					long pcnt = p_map[j][ex][ey];
					if(pcnt == 0)
						continue;
					else if(han >= pcnt)
						gift++;
				}
			}
			if(max < gift)
				max = gift;
		}
		System.out.println(max);
	}
}
/*
4 3
#..
..H
.P.
.P.



for(int j = 0; j<N; j++) {
	for(int k = 0; k<M; k++) {
		System.out.print(p_map[i][j][k]);
	}
	System.out.println();
}
System.out.println();	
			
*/

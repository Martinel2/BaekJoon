import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class S{
		int x;
		int y;
		
		S(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int n,m;
	
	static boolean check(int x, int y) {
		return (0<=x && x<n) && (0<=y && y<m);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int[][] map;
	    int[][] cnt;
		boolean[][] visit;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		cnt = new int[n][m];
		
		int sx=0,sy=0;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		Queue<S> q= new LinkedList<>();
		q.add(new S(sx,sy));
		visit[sx][sy] = true;
		
		while(!q.isEmpty()) {
			S now = q.poll();
			int x = now.x;
			int y = now.y;
			
			int c = cnt[x][y];
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(check(nx,ny) && !visit[nx][ny] && map[nx][ny] != 0) {
					cnt[nx][ny] = c+1;
					visit[nx][ny] = true;
					q.add(new S(nx,ny));
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 1 && cnt[i][j] == 0)
					cnt[i][j] = -1;
				sb.append(cnt[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}

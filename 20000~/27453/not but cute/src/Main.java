import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class P{
		mov p;
		int cnt = 0;
		
		
		P(mov p, int cnt){
			this.p = p;
			this.cnt = cnt;
		}
		
	}
	
	static class mov{
		int cx;
		int cy;
		int bx;
		int by;
		
		mov(int bx, int by, int cx, int cy){
			this.bx=bx;
			this.by=by;
			this.cx=cx;
			this.cy=cy;
		}
	}
	
	static boolean check(int x, int y) {
		if(((0 <= x && x < N) && (0 <= y && y < M)) && map[x][y] >= 0)
			return true;
		else return false;
	}
	
	static int[][] map;
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		boolean[][][] visit = new boolean[4][N][M];
		Queue<P> move = new LinkedList<>();
		
		int strx = 0, stry = 0;
		int endx = 0, endy = 0;
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				if(s.charAt(j) == 'S') {
					map[i][j] = 0;
					strx = i;
					stry = j;
				}
				else if(s.charAt(j) == 'H') {
					map[i][j] = 0;
					endx = i;
					endy = j;
				}
				else if(s.charAt(j) == 'X')
					map[i][j] = -1;
				else
					map[i][j] = s.charAt(j)-'0';
				//System.out.print(map[i][j]+" ");
			}
			//System.out.println();
		}
		boolean clear = false;
		for(int i = 0; i<4; i++) {
			int nx = strx+dx[i];
			int ny = stry+dy[i];
			visit[i][strx][stry] = true;
			if(check(nx,ny) && map[nx][ny] <= K) {
				if(nx == endx && ny == endy) {//µµÂøÁ¡
					clear = true;
					move.clear();
					System.out.println(1);
					break;
				}
				P next = new P(new mov(strx,stry,nx,ny), 1);
				move.add(next);
			}
		}
		while(!move.isEmpty() && !clear) {
			P cur = move.poll();
			int bx = cur.p.bx;
			int by= cur.p.by;
			int cx = cur.p.cx;
			int cy = cur.p.cy;
			int cnt = cur.cnt;
			
			for(int i = 0; i<4; i++) {
				if(!visit[i][cx][cy]) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if(check(nx,ny) && (bx != nx || by != ny)) {
						if(nx == endx && ny == endy) {//µµÂøÁ¡
							clear = true;
							move.clear();
							System.out.println(cnt+1);
							break;
						}
						else {
							int bul = map[bx][by] + map[cx][cy] + map[nx][ny];
							if(bul <= K) {
								P next = new P(new mov(cx,cy,nx,ny), cnt+1);
								move.add(next);
								visit[i][cx][cy] = true;
								//System.out.println(nx+" "+ny+" "+(cnt+1));
							}	
						}
					}
				}
			}
		}
		if(!clear)
			System.out.println(-1);
 	}
}
/*
6 6 4
S1113X
33323X
11211X
13311X
1XXXXX
11111H
*/
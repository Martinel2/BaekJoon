import java.io.*;
import java.util.*;

//7562 나이트의 이동
public class Main {
	
	static int[] dx = {-1,-2,-2,-1, 1,2,2,1};
	static int[] dy = {-2,-1,1,2, 2,1,-1,-2};
	static class XY{
		int x,y;
		int cnt = 0;
		
		XY(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			Queue<XY> Q = new LinkedList<>(); 
			int min = 0;
			int I = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			visit[x][y]= true;
			Q.add(new XY(x,y));
			
			st = new StringTokenizer(br.readLine(), " ");
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			
			while(!Q.isEmpty()) {
				XY cur = Q.poll();
				if(cur.x == endx && cur.y == endy){
					min = cur.cnt;
					break;
				}
				for(int i = 0; i<8; i++) {
					int nx = cur.x+dx[i];
					int ny = cur.y+dy[i];
					if( (0 <= nx && nx < I) && (0 <= ny && ny < I) && !visit[nx][ny]) {
						visit[nx][ny] = true;
						XY next = new XY(nx,ny);
						next.cnt = cur.cnt+1;
						Q.add(next);
					}
				}
			}
			sb.append(min).append("\n");
		}
		System.out.print(sb);
	}
}


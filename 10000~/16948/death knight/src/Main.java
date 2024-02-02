import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class X {
	int x,y;
	int cnt;
	
	X(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		boolean[][] visit = new boolean[n][n];
		int[] dx = {-2,-2,0,0,2,2};
		int[] dy = {-1,1,-2,2,-1,1};
		
		Queue<X> q = new LinkedList<>();
		
		q.add(new X(x1,y1,0));
		visit[x1][y1] = true;
		
		while(!q.isEmpty()) {
			X now = q.poll();
			if(now.x == x2 && now.y == y2) {
				ans = now.cnt;
				break;
			}
			for(int i = 0; i<6; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if((0 <= nx && nx < n) && (0 <= ny && ny < n)
						&& !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new X(nx,ny,now.cnt+1));
				}
			}
		}
		if(!visit[x2][y2])
			ans = -1;
		
		System.out.println(ans);
	}
}

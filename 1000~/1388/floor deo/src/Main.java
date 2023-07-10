import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1388
public class Main {
	
	static char[][] floor;
	static boolean[][] visit;
	static int N,M;
	
	static void dfs(int x, int y) {
		
		visit[x][y] = true;
		if(floor[x][y] == '|') {
			if(x+1 < N && floor[x+1][y] == '|')
				dfs(x+1, y);
		}
		else {
			if(y+1 < M && floor[x][y+1] == '-')
				dfs(x, y+1);
		}
			
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		floor = new char[N][M];
		visit = new boolean[N][M];
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<M; j++) {
				floor[i][j] = line.charAt(j);
			}
		}
		
		
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}

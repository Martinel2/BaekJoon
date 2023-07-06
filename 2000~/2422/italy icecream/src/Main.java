import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2422
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		boolean[][] dis = new boolean[N+1][N+1];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			dis[A][B] = true;
			dis[B][A] = true;
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				if(dis[i][j])
					continue;
				for(int k = j+1; k<=N; k++) {
					if(dis[i][k] || dis[j][k])
						continue;
					else
						ans++;
				}
			}
		}
		System.out.println(ans);
	}
}

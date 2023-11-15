package roma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	static int[] roma = {1, 5, 10, 50};
	static int ans = 0;
	static boolean[] visit;
	
	static void dfs(int sum, int idx, int cnt) {
		if(cnt == 0) {
			if(visit[sum])
				return;
			else {
				visit[sum] = true;
				ans++;
				return;
			}
		}
		else {
			for(int i = idx; i<4; i++) {
				dfs(sum+roma[i], i, cnt-1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		visit = new boolean[50*N+1];
		
		dfs(0, 0, N);
		
		System.out.println(ans);
	}
}

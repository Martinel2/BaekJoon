package guitarlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][max+1];
		dp[0][start] = 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			int vol = Integer.parseInt(st.nextToken());
			for(int j = 0; j<=max; j++) {
				if(dp[i][j] == 1) {
					if(j+vol <= max) dp[i+1][j+vol] = 1;
					if(j-vol>=0) dp[i+1][j-vol] = 1;
				}
			}
		}
		
		int ans = -1;
		for(int i=max; i>=0; i--) {
			if(dp[n][i] ==1) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}

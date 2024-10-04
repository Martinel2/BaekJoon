package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//1 0,1,2,3,4
		//2 01,02,03,04  10,20,30,40  13,14,24,31,41,42
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][5];
		long mod = 1000000007;
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[1][3] = 1;
		dp[1][4] = 1;
		
		for(int i = 2; i<=n; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4])%mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][3] + dp[i-1][4])%mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][4])%mod;
			dp[i][3] = (dp[i-1][0] + dp[i-1][1])%mod;
			dp[i][4] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%mod;
		}
		long ans = (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4])%mod;
		System.out.println(ans);
	}
}
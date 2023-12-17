package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[][] dp;
 	static long dynamic(int n, int m) {
 		if(n == 0 || m == 0)
 			return 0;
 		
 		if(dp[n][m] != 0)
 			return dp[n][m];
 		
 		dp[n][m] = (dynamic(n-1, m) + dynamic(n, m-1) + dynamic(n-1, m-1)) % 1000000007;
 		return dp[n][m];
 	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new long[n+1][m+1];
		dp[1][1] = 1;
		System.out.println(dynamic(n,m));
	}
}

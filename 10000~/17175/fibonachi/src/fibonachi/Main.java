package fibonachi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[] dp;
	static long fibo(int n) {
		if(dp[n] != 0)
			return dp[n];
		else
			return dp[n] = (fibo(n-1) + fibo(n-2) + 1) % 1000000007;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		dp[0] = 1;
		if(n > 0)
			dp[1] = 1;
		System.out.println(fibo(n));
	}
}

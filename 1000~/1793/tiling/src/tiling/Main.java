package tiling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static BigInteger[] dp;
	
	static BigInteger dynamic(int n) {
		if(!dp[n].equals(new BigInteger("0")))
			return dp[n];
		else
			dp[n] = dynamic(n-1).add(dynamic(n-2).multiply(new BigInteger("2")));
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp = new BigInteger[251];
		
		for(int i = 0; i<=250; i++) {
			dp[i] = new BigInteger("0");
		}
		
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		//dp[n] = dp[n-1] + 2*dp[n-2]
		
		String s = null;
		while((s= br.readLine()) != null) {
			int n = Integer.parseInt(s);
			
			sb.append(dynamic(n)).append('\n');
		}
		System.out.println(sb);
	}
}

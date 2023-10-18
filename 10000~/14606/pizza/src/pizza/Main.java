package pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp;
	
	static int fun(int N) {
		if(N <= 1)
			return 0;
		else {
			if(dp[N] != 0)
				return dp[N];
			else {
				int d1 = (int)Math.ceil(N/2);
				int d2 = N - d1;
				return (d1*d2) + fun(d1) + fun(d2);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		System.out.println(fun(N));
		
	}
}

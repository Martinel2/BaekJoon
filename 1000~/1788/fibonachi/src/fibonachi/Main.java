package fibonachi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//fn = fn+2-fn+1

public class Main {
	
	static long dp[];
	static int num;
	static long fibo(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else if(n > 1) {
			int k = Math.abs(n) + Math.abs(num);
			if(dp[k] != 0)
				return dp[k];
			else {
				dp[k] = (fibo(n-1) + fibo(n-2)) % 1000000000;
				return dp[k];
			}
		}
		else {
			int k = n + Math.abs(num);
			if(dp[n + Math.abs(num)] != 0)
				return dp[n + Math.abs(num)];
			else {
				dp[k] = (fibo(n+2) - fibo(n+1)) % 1000000000;
				return dp[k];
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		
		dp = new long[Math.abs(num)*2+1];
		
		long f = fibo(num);
		
		int o = 1;
		
		if(f == 0)
			o = 0;
		else if(f < 0)
			o = -1;
		
		System.out.println(o + "\n" + Math.abs(f));
	}
}

package seq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 0)
			System.out.println(1);
		else {
			long[] dp = new long[N+1];
			dp[0] = 1;
			dp[1] = 1;
			
			for(int n = 2; n<=N; n++) {
				int left = 0;
				int right = n-1;
				while(left < right) {
					dp[n] += dp[left] * dp[right];
					left += 1;
					right -= 1;
				}
				dp[n] *= 2;
				if(left == right) 
					dp[n] += dp[left] * dp[right];
				//System.out.println("dp["+n+"] = "+dp[n]);
			}
			System.out.println(dp[N]);
		}
	}
}

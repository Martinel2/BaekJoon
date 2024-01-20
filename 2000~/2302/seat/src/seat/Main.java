package seat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[n+1];
		long[] dp = new long[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i<41; i++) dp[i] = dp[i-1] + dp[i-2];
		
		int str = 0;
		int end = 0;
		int ans = 1;
		for(int i = 0; i<m; i++) {
			end = Integer.parseInt(br.readLine());
			ans *= dp[end-str-1];
			str = end;
		}
		ans *= dp[n-str];
		
		System.out.println(ans);
	}
}

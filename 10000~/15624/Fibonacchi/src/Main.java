import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		if(N == 1)
			ans = 1;
		else if(N>1) {
			long[] dp = new long[N+1];
			dp[1] = 1;
			for(int i  = 2; i<=N; i++) {
				dp[i] = (dp[i-1] + dp[i-2])% 1000000007;
			}
			ans = dp[N];
		}
		System.out.println(ans);
	}
}

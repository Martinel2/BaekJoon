import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1-CY 2-SK 3-CY 4-SK 5-SK 6-SK 7-SK 8-
		int N = Integer.parseInt(br.readLine());
		
		boolean[] dp = new boolean[N+1];
		dp[1] = false;
		dp[2] = true;
		dp[3] = false;
		dp[4] = true;
		for(int i = 5; i<=N; i++) {
			if(!dp[i-1] || !dp[i-3] || !dp[i-4])
				dp[i] = true;
		}
		String ans = dp[N]? "SK":"CY";
		System.out.println(ans);
	}
}

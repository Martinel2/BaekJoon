import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//15988 1,2,3 더하기 3
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long div = 1000000009;
		
		// dp[n] = dp[n-1] + dp[n-2] + dp[n-3] (n>=4)
		long[] dp = new long[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(dp[N] == 0) {
				for(int i = 4; i<=N; i++) {
					if(dp[i] != 0)
						continue;
					//위에서 구한 점화식으로 계산
					else
						dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%div;
				}
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}

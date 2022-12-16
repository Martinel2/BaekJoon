import java.io.*;

//15990 1,2,3 ¥ı«œ±‚ 5
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long div = 1000000009;
		long[][] dp = new long[100001][3];
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][2] = 1;
		dp[3][1] = 1;
		dp[3][0] = 1;
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			long ans;
			if(dp[N][0] != 0 || dp[N][1] != 0 || dp[N][2] != 0) {
				ans = (dp[N][0] + dp[N][1] + dp[N][2])%div;
				sb.append(ans).append("\n");
			}
			else {
				for(int i = 4; i<=N; i++){
					if(dp[i][0] != 0 || dp[i][1] != 0 || dp[i][2] != 0)
						continue;
					dp[i][0] = (dp[i-1][1] + dp[i-1][2])%div;
					dp[i][1] = (dp[i-2][0] + dp[i-2][2])%div;
					dp[i][2] = (dp[i-3][0] + dp[i-3][1])%div;
				}
				ans = (dp[N][0] + dp[N][1] + dp[N][2])%div;
				sb.append(ans).append("\n");
			}
		}
		System.out.println(sb);
	}
}

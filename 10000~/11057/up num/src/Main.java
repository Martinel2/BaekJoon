import java.io.*;
import java.util.*;


//11057 오르막수 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][11];
		dp[1][10] = 1;
		for(int i = 1; i<10; i++) {
			dp[1][i] = 1;
			dp[1][10] += dp[1][i];
		}
		for(int i = 2; i<=N; i++) {
			dp[i][0] = 1;
			dp[i][10] = 1;
			for(int j = 1; j<10; j++) {
				dp[i][j] = dp[i][j-1]%10007 + dp[i-1][j]%10007;
				dp[i][10] += dp[i][j];
				dp[i][10]%= 10007;
			}
		}
		System.out.println(dp[N][10]);
	}
}
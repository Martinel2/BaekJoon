import java.util.*;
import java.io.*;

//11051 이항 계수 2
public class Main {
//nCk = (n-1)Ck + (n-1)C(k-1)
	static int[][] dp;
	static int combination(int N, int K) {
		if(dp[N][K] != 0)
			return dp[N][K];
		else if(N == 1 || K == N || K == 0)
		{
			dp[N][K] = 1;
			return dp[N][K];
		}
		else if(K == 1 || K == N-1) {
			dp[N][K] = N;
			return dp[N][K];
		}
		else
		{
			if(dp[N-1][K] != 0 && dp[N-1][K-1] != 0)
				dp[N][K] = (dp[N-1][K] + dp[N-1][K-1])%10007;
			else
				dp[N][K] = (combination(N-1,K-1) + combination(N-1,K)) % 10007;
			return dp[N][K];
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K == 0 || K == N)
			System.out.println(1);
		else if(K == 1 || K == N-1)
			System.out.println(N);
		else {
			K = Math.min(K, N-K);
			dp = new int[N+1][K+1];
			System.out.print(combination(N,K));
		}
	}
}
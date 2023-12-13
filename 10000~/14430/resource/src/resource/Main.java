package resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][M+1];
		
		int[][] area = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = area[1][1];
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + area[i][j];
			}
		}
		
		System.out.println(dp[N][M]);
	}
}

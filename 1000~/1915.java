package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//1915
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			String s = br.readLine();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(arr[i][j] == 1)
				{
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println(ans*ans);
	}
}
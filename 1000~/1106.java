package solved;

import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[c+101];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());
			
			for(int j = profit; j<c+101; j++) {
				dp[j]=Math.min(dp[j], w+dp[j-profit]);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=c; i<c+101; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
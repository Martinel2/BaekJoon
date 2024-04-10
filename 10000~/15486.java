package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = -1;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+2];
		
		int[][] arr = new int[n+2][2];
		
		for(int i = 1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			arr[i][0] = day;
			arr[i][1] = time;
		}
		
		for(int i=1; i<=n+1; i++) {
			if(dp[i] > max)
				max = dp[i];
			
			int day = i+arr[i][0];
			if(day <= n+1) {
				dp[day] = Math.max(dp[day], max+arr[i][1]);
			}
		}
		
		System.out.println(dp[n+1]);
		
	}
}
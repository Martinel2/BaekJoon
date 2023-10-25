package invest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());	
		
		int[] dp = new int[11];
		
		dp[0] = H;
		dp[1] = (int)(dp[0]*1.05);
		dp[2] = (int)(dp[1]*1.05);
		dp[3] = Math.max((int)(dp[2]*1.05), (int)(dp[0]*1.20));
		dp[4] = Math.max((int)(dp[3]*1.05), (int)(dp[1]*1.20));
		
		for(int i = 5; i<=Y; i++) 
			dp[i] = (int) Math.max((int)dp[i-5]*1.35, Math.max((int)dp[i-3]*1.2, (int)dp[i-1]*1.05));
		
		System.out.println(dp[Y]);
	}
}

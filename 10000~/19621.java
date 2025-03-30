package solved;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//StringBuilder sb= new StringBuilder();
		
		int n= Integer.parseInt(br.readLine());
		
		int[] meeting = new int[Math.max(n, 2)];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			meeting[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[Math.max(n, 2)];
		dp[0] = meeting[0];
		dp[1] = Math.max(meeting[0], meeting[1]);
		for(int i=2; i<n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+meeting[i]);
			//System.out.println(dp[i]);
		}
		System.out.println(dp[n-1]);
	}
}
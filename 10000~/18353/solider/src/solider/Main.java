package solider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		int max = 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = n-1; i>=0; i--) {
			arr[i]= Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					if(max < dp[i])
						max = dp[i];
				}
			}
		}
		
		System.out.println(n-max);
	}
}

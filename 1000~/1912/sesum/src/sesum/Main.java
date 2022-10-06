package sesum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1912 연속합
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;				// N 숫자 개수
		N = Integer.parseInt(br.readLine());
	
		int[] arr = new int[N];
		long[] dp = new long[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		long max = dp[0];
		
		for(int i = 1; i<N; i++)
		{
			if(dp[i-1] > 0)
				dp[i] += dp[i-1];
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.println(max);
	}
}
package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//14226
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = arr[1];
		dp[1][0] = arr[1];
		dp[1][1] = arr[1];
		for(int i =2; i<=n; i++) {
			//그냥 더하는 경우
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
			max = Math.max(max, dp[i][0]);
			
			//수를 제거하는 경우
			dp[i][1] = Math.max(dp[i-1][1]+arr[i], dp[i-1][0]);
			max = Math.max(max, dp[i][1]);
			
		}
		
		System.out.println(max);
	}
}
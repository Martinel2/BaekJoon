package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//가장 긴 연속 부분 수열
		int[] dp = new int[n];
		
		int max = 0;
		for(int i = 0; i<n; i++) {
			dp[i] = 1;
			for(int j = 0; j<n; j++) {
				if(arr[j]<arr[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
			}
		}
		
		int ans = n-max;
		System.out.println(ans);
	}
}
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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n+1];
			int[] dp = new int[10001];
			for(int i = 1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(br.readLine());
			
			dp[0] = 1;
			for(int i = 1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(j>=arr[i]) dp[j] += dp[j-arr[i]];
				}
			}
			sb.append(dp[m]).append('\n');
		}
		System.out.println(sb);
	}
}
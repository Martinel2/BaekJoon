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
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][3];
		
		int[][] arr = new int[n+1][3];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 9999999;
		
		for(int i = 0; i<3; i++) {
			//i번째 집을 j색으로 칠하는 경우중 최소값
			//i-1번째 집까지를 다른 두 가지 색으로 칠한 경우중 최소값 + j로 칠하는 비용
			//고려하지 않은 것: 1번과 N번 집의 색이 달라야 함.
			//1번집의 색을 정해두고 시작
			for(int j = 0; j<3; j++) {
				if(j == i) dp[1][j] = arr[1][j];
				else dp[1][j] = 9999999;
			}
			
			for(int j = 2; j<=n; j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
			}
			for(int j = 0; j<3; j++) {
				if(j==i) continue;
				else ans = Math.min(ans,dp[n][j]);
			}
		}
		
		System.out.println(ans);
	}
}
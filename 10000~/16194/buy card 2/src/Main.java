import java.io.*;
import java.util.*;

//16194 카드 구매하기 2
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			if(dp[i] == 0 || dp[i] > cost[i])
				dp[i] = cost[i];
			for(int j = 1; i+j<=N; j++) {
				int sum = dp[i] + dp[j];
				if(dp[i+j] == 0 || sum < dp[i+j])
					dp[i+j] = sum;
			}
		}
		System.out.println(dp[N]);
	}
}

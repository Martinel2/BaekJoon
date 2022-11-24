import java.io.*;
import java.util.*;


//11052 카드구매하기
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			dp[i] = card[i];
		}
		for(int i = 1; i<=N; i++) {
			for(int j = i/2; j>=0; j--) {
				dp[i] = Math.max(dp[i-j]+dp[j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
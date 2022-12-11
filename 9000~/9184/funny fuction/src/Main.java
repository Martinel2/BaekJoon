import java.io.*;
import java.util.*;

//9184 신나는 함수 실행
public class Main {
	
	static int[][][] dp = new int[51][51][51];
	
	static int fuc(int a, int b, int c) {

		if(a<=0 || b<=0 || c<=0) {
			dp[a][b][c] = 1;
			return dp[a][b][c];
		}
		else if(a>20 || b>20 || c>20) {
			if(dp[20][20][20] != 0) {
				dp[a][b][c] = dp[20][20][20];
				return dp[a][b][c];
			}
			else {
				dp[a][b][c] = fuc(20,20,20);
				return dp[a][b][c];
			}
		}
		else if(a<b && b<c) {
			if(dp[a][b][c-1] != 0)
				dp[a][b][c] += dp[a][b][c-1];
			else
			{
				dp[a][b][c] += fuc(a,b,c-1);
			}
			
			if(dp[a][b-1][c-1] != 0)
				dp[a][b][c] += dp[a][b-1][c-1];
			else
			{
				dp[a][b][c] += fuc(a,b-1,c-1);
			}
			
			if(dp[a][b-1][c] != 0)
				dp[a][b][c] -= dp[a][b-1][c];
			else
			{
				dp[a][b][c] -= fuc(a,b-1,c);
			}
			
			return dp[a][b][c];
		}
		else {
			if(dp[a-1][b][c] != 0)
				dp[a][b][c] += dp[a-1][b][c];
			else
			{
				dp[a][b][c] += fuc(a-1,b,c);
			}
			
			if(dp[a-1][b-1][c] != 0)
				dp[a][b][c] += dp[a-1][b-1][c];
			else
			{
				dp[a][b][c] += fuc(a-1,b-1,c);
			}
			
			if(dp[a-1][b][c-1] != 0)
				dp[a][b][c] += dp[a-1][b][c-1];
			else
			{
				dp[a][b][c] += fuc(a-1,b,c-1);
			}
			
			if(dp[a-1][b-1][c-1] != 0)
				dp[a][b][c] -= dp[a-1][b-1][c-1];
			else
			{
				dp[a][b][c] -= fuc(a-1,b-1,c-1);
			}
			
			return dp[a][b][c];
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		while(a != -1 || b != -1 || c != -1) {
			if(a<=0 || b<=0 || c<=0)
				sb.append("w("+a+", "+b+", "+c+") = ").append(1).append("\n");
			else 
				sb.append("w("+a+", "+b+", "+c+") = ").append(fuc(a,b,c)).append("\n");
			
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
}

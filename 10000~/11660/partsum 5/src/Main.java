import java.io.*;
import java.util.*;


//11660 구간 합 구하기 5
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//표의 크기
		int M = Integer.parseInt(st.nextToken());//합하는 횟수
		int[][] dp = new int[N+1][N+1];
		
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++)
			{
				int a = Integer.parseInt(st.nextToken());
				dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] -dp[i][j] + a;
			}
		}
		
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb);
	}
}
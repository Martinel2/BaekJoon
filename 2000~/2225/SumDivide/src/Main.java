import java.io.*;
import java.util.*;


//2225 �պ���
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		int[][] dp = new int[K+1][N+1];
		
		for(int i=1;i<=K;i++) {
			dp[i][0]=1;
		}
		
		for(int i=1;i<=K;i++) 
		{	
			for(int j=1;j<=N;j++) 
			{
				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; // 1000000000���� ������ �� ����� �� �ָ� Ʋ�ȴٰ� ��.
			}
		}
		System.out.println(dp[K][N]);
	}
}

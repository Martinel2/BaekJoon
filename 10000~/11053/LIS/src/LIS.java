import java.io.*;
import java.util.*;


public class LIS {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		int max = 0;
 		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		for(int i =0; i<N; i++)
		{
			A[i] = Integer.parseInt(tk.nextToken());
		}
		for(int i = 0; i<N; i++)
		{
			dp[i] = 0;
			for(int j = i-1; j>=0; j--)
			{
				if(A[i] > A[j] && dp[i] < dp[j])
					dp[i] = dp[j];
			}
			dp[i]++;
			if(max<dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}

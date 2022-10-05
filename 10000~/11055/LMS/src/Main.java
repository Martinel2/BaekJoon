import java.io.*;
import java.util.*;


//11055 가장 큰 증가하는 부분 수열
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long[] dp = new long[N];
		long max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<N; i++)
		{
			for(int j = i-1; j>=0; j--)
			{
				if(arr[i] > arr[j] && dp[i] < dp[j])
					dp[i] = dp[j];
			}
			dp[i] += arr[i];
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
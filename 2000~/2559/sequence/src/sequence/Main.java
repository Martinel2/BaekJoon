package sequence;
import java.io.*;
import java.util.*;


//2559 ¼ö¿­
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i<K; i++)
			dp[0] += arr[i];
		int max = dp[0];
		for(int i = 1; i<N-K; i++)
		{
			dp[i] = dp[i-1]-arr[i-1]+arr[i+K-1];
			if(max<dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
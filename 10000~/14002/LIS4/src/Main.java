import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		String mc = "";
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		String[] sdp = new String[N];
		int max = 0;
 		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		for(int i =0; i<N; i++)
		{
			A[i] = Integer.parseInt(tk.nextToken());
			sdp[i]="";
		}
		for(int i = 0; i<N; i++)
		{
			dp[i] = 0;
			for(int j = i-1; j>=0; j--)
			{
				if(A[i] > A[j] && dp[i] < dp[j]) {
					dp[i] = dp[j];
					if(sdp[j] == "")
						sdp[i] += A[j];
					else
						sdp[i] = sdp[j];
				}
			}
			dp[i]++;
			if(sdp[i] == "")
				sdp[i] += A[i];
			else
				sdp[i] = sdp[i] + " " + A[i];
			if(max<dp[i])
			{
				max = dp[i];
				mc = sdp[i];
			}
		}
		
		System.out.println(max);
		System.out.println(mc);
	}
}

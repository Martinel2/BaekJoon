import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N %2 != 0)
			System.out.print(0);
		else {
			long[] dp = new long[N/2];
			dp[0] = 3;
			for(int i = 1; i<N/2; i++)
			{
				dp[i] = dp[ i-1 ] * dp[ i-1 ];
			
			}
		
			System.out.print(dp[N/2-1]);
		}
	}
}

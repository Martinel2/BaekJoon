import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		int max = 0;
		String A = br.readLine();
		String B = br.readLine();
		int lenA = A.length();
		int lenB = B.length();
		int[][] dp = new int[lenA+1][lenB+1];
		for(int i = 1; i<=lenA; i++)
		{
			dp[i][0] = 0;
		}
		for(int i = 1; i<=lenB; i++)
			dp[0][i] = 0;
		
		for(int i = 1; i<=lenA; i++) {
			for(int j = 1; j<=lenB; j++)
			{
				if(A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					if(max<dp[i][j]) {
						max = dp[i][j];
						st.append(A.charAt(i-1));
					}
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		System.out.println(dp[lenA][lenB]);
		System.out.println(st);
	}
}

import java.io.*;
import java.util.*;

//2293 µ¿Àü1
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(tk.nextToken());
		k = Integer.parseInt(tk.nextToken());
		
		coin = new int[n];
		
		for(int i = 0; i<n ; i++)
		{
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[10001];
		dp[0] = 1;
		for(int i = 0; i< n; i++)
		{
			for(int j = coin[i]; j<=k; j++)
			{
				if(dp[j-coin[i]] !=0)
					dp[j] += dp[j-coin[i]];
			}
		}
		System.out.print(dp[k]);
		
	}
	static int n,k;
	static int[] coin;
	
}

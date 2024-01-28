package path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long kpath = 1;
		long end = 1;
		
		if(k != 0) {
			int kx = (k-1) % n;
			int ky = (k-1) % m;
			long[][] dp = new long[kx+1][ky+1];
			dp[0][0] = 1;
			for(int i = 0; i<=kx; i++) {
				for(int j = 0; j<=ky; j++) {
					long up = 0;
					long left = 0;
					if(0<= i-1)
						up = dp[i-1][j];
					if(0<= j-1)
						left = dp[i][j-1];
					if(up !=0 || left != 0)
						dp[i][j] = up+left;
				}
			}
			kpath = dp[kx][ky];
			n -= kx;
			m -= ky;
		}
		
		long[][] dp = new long[n][m];
		dp[0][0] = 1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				long up = 0;
				long left = 0;
				if(0<= i-1)
					up = dp[i-1][j];
				if(0<= j-1)
					left = dp[i][j-1];
				if(up !=0 || left != 0)
					dp[i][j] = up+left;
			}
		}
		end = dp[n-1][m-1];
		System.out.print(kpath * end);
	}
}

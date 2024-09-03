package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		// 1 - 1,2,3
		// 2 - 1,2,3,4
		// 3 - 1,2,3,4,5
		// 4 - 2,3,4,5,6
		// 5 - 3,4,5,6,7
		// 6 - 4,5,6,7,8
		// 7 - 5,6,7,8,9
		// 8 - 6,7,8,9
		// 9 - 7,8,9
		
		//  11,21,31 (1,2,3)
		// 12,22,32,42 (1,2,3,4)
		// 13,23,33,43,53 (1,2,3,4,5)
		
		// 111,121,131, 211,221,231,311, 321,331,421,431,531
		
		
		
		int n = Integer.parseInt(br.readLine());
		
		long mod = 987654321;
		long[][] dp = new long[n+1][10];
		for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    dp[i][j] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;
                } else if (j == 2) {
                    dp[i][j] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % mod;
                } else if (j == 8) {
                    dp[i][j] = (dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % mod;
                } else if (j == 9) {
                    dp[i][j] = (dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 2] + dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1] + dp[i - 1][j + 2]) % mod;
                }
            }
        }
        
        long sum = 0L;
        for (int i = 1; i <= 9; i++) {
            sum += dp[n][i] % mod;
        }

        System.out.println(sum % mod);
	}
}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n,cnt;
	static long ans;
	
	static void backtracking(int prefix, long num, int d, int c) {
		if(d == c) {
			cnt++;
			if(cnt == n) {
				ans = num;
				return;
			}
		}
		if(d != c) {
			for(int i = 0; i<prefix; i++) {
				backtracking(i,(num*10)+i,d,c+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9/ 10
		//20 21 / 30 31 32 / 43 42 41 40 ...
		//210 / 32*2 310 /43*3 42*2 410
		// 앞자리 수에 앞자리 보다 작은 수로 시작하는 수의 1/10배한 것의 갯수
		//Ex) 300 + (20,21) + (10)
		//dp[k][n] = dp[k][n-1] + dp[k-1][n-1]
		n = Integer.parseInt(br.readLine())+1;
		cnt = 0;
		ans = -1;
		
		if(n <= 1023) {
			
			if(n <= 10) ans = n-1;
			else {
				int[][] dp = new int[11][10];
				
				for(int i = 0; i<10; i++) {
					cnt++;
					dp[1][i] = 1;
				}
				
				if(ans == -1) {
					Loop: for(int i = 2; i<=10; i++) {
						for(int j = i-1; j<=9; j++) {
							dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
							cnt += dp[i][j];
							//System.out.println(cnt);
							if(cnt >= n) {
								cnt -= dp[i][j];
								backtracking(j,j, i,1);
								break Loop;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
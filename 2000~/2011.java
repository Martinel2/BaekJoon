package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		//두자리가 26이하의 수일때, 두자리를 읽을 수 있는 방법이 두가지
		//25114  2 5 1 1 4 | 2 5 1 14 | 2 5 11 4 | 25 1 1 4 | 25 1 14 | 25 11 4
		int ans = 0;
		
		int len = s.length();
		
		if(len > 0 && !s.substring(0,1).equals("0")) {
			
			int[] dp = new int[len+1];
			dp[0] = 1;
			dp[1] = 1;
				
			if(len == 1)
				ans = 1;
			
			for(int i = 2; i<=len; i++) {
				if(s.charAt(i-1)-'0' == 0 && (s.charAt(i-2)-'0' == 0 || s.charAt(i-2)-'0' >= 3)) {
					//System.out.println(s.charAt(i-2) + " " + s.charAt(i-1));
					ans = 0;
					break;
				}
				int num = Integer.parseInt(s.substring(i-2,i));
				if(s.charAt(i-1) != '0')
					dp[i] += dp[i-1]%1000000;
				if(10<= num && num <= 26)
					dp[i] += dp[i-2]%1000000;
				ans = dp[i];
			}
		}
		//dp[i][0] = dp[i-1][0] + dp[i-1][1]
		//dp[i][1] = dp[i-2][0] + dp[i-2][1]
		
		System.out.println(ans);
	}
}
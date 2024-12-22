package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c;
        int[] dp = new int[k+1];
		st = new StringTokenizer(br.readLine());
		Arrays.fill(dp, 1000000000);
		dp[0] = 0;
		while(n-->0) {
			c = Integer.parseInt(st.nextToken());
			for(int i=k;i>=c;i--) dp[i] = Math.min(dp[i], dp[i-c]+1);
		}
		//4 5
		// 1 1 3 2
		// 0 INF INF INF INF INF  <- 초기상태
		// 0  1  INF INF INF INF  <- 1
		// 0  1   2  INF INF INF  <- 1
		// 0  1   2   1   2   3(dp[5] = min(dp[5],dp[5-3=2]+1)   <- 3
		// 0  1   2   1   2   2   <- 2
		System.out.println(dp[k]>100?"-1":dp[k]);
    }
}
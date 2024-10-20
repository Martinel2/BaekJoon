package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int x, y;
    static long[][] dp;

    final static long MOD = 1_000_000_007;
	private static long doDp(int r, int c) {
        if(r < 1 || c < 1 || r > x || c > y) {
            return 0;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        if(c % 2 == 0) {
            return dp[r][c] = (doDp(r + 1, c - 1) + doDp(r, c - 1) + doDp(r - 1, c)) % MOD;
        }else {
            return dp[r][c] = (doDp(r, c - 1) + doDp(r - 1, c - 1) + doDp(r - 1, c)) % MOD;
        }
    }
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	x = Integer.parseInt(st.nextToken());
    	y = Integer.parseInt(st.nextToken());
    	
    	dp = new long[x+1][y+1];
    	
    	for(int i = 0; i < x + 1; i++) {
            for(int j = 0; j < y + 1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 1;

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            dp[hx][hy] = 0;
        }

        System.out.println(doDp(x, y));
    }
}

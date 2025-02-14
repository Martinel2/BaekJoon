package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int t,w;
        
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[t+1][w+1];
        int[] ja = new int[t+1];
        for(int i = 1; i<=t; i++) {
        	ja[i] = Integer.parseInt(br.readLine());
        	dp[i][0] = dp[i-1][0];
        	if(ja[i] == 1) {
        		dp[i][0]++;
        	}
        }
        
        int ans = 0;
        
        for(int i=1; i<=t; i++) {
        	for(int j=0; j<=w; j++) {
        		dp[i][j] = dp[i-1][j];
        		//움직인상태에서 자두를 먹는 경우
        		if((j % 2 != 0 && ja[i] == 2) 
        				|| (j % 2 == 0 && ja[i] == 1)) {
        			dp[i][j]++;
        		}
        		else if(j != 0){
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
        		}
        		ans = Math.max(ans, dp[i][j]);
        	}
        }
        System.out.println(ans);
	}
}
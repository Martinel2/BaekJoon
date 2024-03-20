package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        st =  new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] memory = new long[n+1];
        long[] c = new long[n+1];
        long ans = Long.MAX_VALUE;
        long sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) memory[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
        	c[i] = Integer.parseInt(st.nextToken());
        	sum += c[i];
        }
        
        long[][] dp = new long[n+1][(int)sum+1];
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j <= sum; j++) {
        				
        		
        		if(c[i] > j) {
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        		}
        		 
        		else {
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - (int)c[i]] + memory[i]);
        		}
        		
        		if(dp[i][j] >= m) {
        			ans = Math.min(ans, j);
            	}
        	}
        	
        }
        
        System.out.println(ans);
        
    }
}
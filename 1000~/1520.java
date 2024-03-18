package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;
    static int[][] arr;
    static int[][] dp;
    
    static int dfs(int x, int y) {
    	
    	if(x == n-1 && y == m-1) {
    		return 1;
    	}
    	
    	if(dp[x][y] != -1)
    		return dp[x][y];
    	
    	dp[x][y] = 0;
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if((0 > nx || nx >= n) || (0 > ny || ny >= m)) {
    			continue;
    		}
    		
    		if(arr[nx][ny] < arr[x][y]) {
    			dp[x][y] += dfs(nx,ny);
    		}
    	}
    	
    	return dp[x][y];
    }
    
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        st =  new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        dp = new int[n][m];
        
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<m; j++) {
        		dp[i][j] = -1;
        	}
        }
        
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(dfs(0,0));
    }
}
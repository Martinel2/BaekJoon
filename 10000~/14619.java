package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] h;
	static ArrayList<Integer>[] e;
	static int[][] dp;
	static int bt(int str, int k) {
		
		if(dp[str][k] != 0) return dp[str][k];
		if(k == 0) {
			if(dp[str][k] == 0)
				dp[str][k] = h[str];
			dp[str][k] = Math.min(h[str], dp[str][k]);
		}
		else {
			for(int next : e[str]) {
				dp[next][k-1] = bt(next,k-1);
				if(dp[str][k] == 0)
					dp[str][k] = dp[next][k-1];
				dp[str][k] = Math.min(dp[next][k-1], dp[str][k]);
			}
		}
		return dp[str][k];
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        dp = new int[n+1][501];
        e = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	e[i] = new ArrayList<>();
        }
        
        
        h = new int[n+1]; 
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	h[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b= Integer.parseInt(st.nextToken());
        	
        	e[a].add(b);
        	e[b].add(a);
        }
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
        	
        	st = new StringTokenizer(br.readLine());
        	int str = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	dp[str][k] = bt(str,k);
        	if(dp[str][k] == 0)
        		sb.append(-1).append('\n');
        	else
        		sb.append(dp[str][k]).append('\n');
        }
        
        System.out.println(sb);
    }
}
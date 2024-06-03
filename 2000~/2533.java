package solved;

import java.util.*;
import java.io.*;

public class Main{

	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i =1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[str].add(end);
			graph[end].add(str);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		
		for(int c : graph[idx]) {
			if(!visited[c]) {
				dfs(c);
				dp[idx][0] += dp[c][1];
				dp[idx][1] += Math.min(dp[c][0], dp[c][1]);
			}
		}
	}
}

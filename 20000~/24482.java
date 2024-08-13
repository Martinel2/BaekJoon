package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int n;
	static boolean[] visit;
	static int[] d;
	static void dfs(ArrayList<Integer>[] arr, int r, int count) {
		visit[r] = true;
		d[r] = count;
		boolean go = false;
		int len = arr[r].size();
		for(int next : arr[r]) {
			if(!visit[next]) {
				go = true;
				dfs(arr,next,count+1);
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int m,r;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken())-1;
		
		ArrayList<Integer>[] arr = new ArrayList[n];
		visit = new boolean[n];
		d = new int[n];
		Arrays.fill(d, -1);
		for(int i = 0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		for(int i = 0; i<n; i++) {
			Collections.sort(arr[i], Collections.reverseOrder());
		}
		
		dfs(arr,r,0);
		for(int val : d) sb.append(val).append('\n');
		System.out.println(sb);
   }
}
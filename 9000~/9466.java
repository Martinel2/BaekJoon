package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static boolean[] visit;
	static int[] arr;
	static int cnt;
	static boolean dfs(int str, int point, int group) {
		if(str == arr[point]) {
			cnt += group;
			return true;
		}
		else {
			if(!visit[arr[point]]) {
				visit[point] = true;
				if(!dfs(str,arr[point],group+1))
					visit[point] = false;
				else return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visit = new boolean[n+1];
			cnt=0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i<=n; i++) {
				if(!visit[i])
					dfs(i,i,1);
				//System.out.println(i+" cnt = "+ cnt);
			}
			
			int ans = n-cnt;
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
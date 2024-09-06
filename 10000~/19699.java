package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean[] che = new boolean[10000];
	static int n,m;
	static int[] cow;
	static boolean[] visit;
	static ArrayList<Integer> ans = new ArrayList<>();
	static int idx=0;
	
	static void backtracking(int cnt, int sum) {
		if(cnt == m) {
			if(!che[sum] && !ans.contains(sum)) ans.add(sum);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				backtracking(cnt+1, sum+cow[i]);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 2; i<10000; i++) {
			if(!che[i]) {
				for(int j = 2; i*j<10000; j++) {
					che[i*j] = true;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cow = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			cow[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0,0);
		
		if(ans.size() > 0) {
			Collections.sort(ans);
			for(int val : ans) System.out.print(val+" ");
		}
		else System.out.println(-1);
	}
}

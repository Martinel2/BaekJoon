package muscle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] mach;
	static boolean[] visit;
	static int ans = 0;
	
	static void backtracking(int str, int cnt) {
		if(str < 500)
			return;
		
		if(cnt == N) {
			ans++;
			return;
		}
		else {
			for(int i = 0; i<N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					backtracking(str+mach[i]-M, cnt+1);
					visit[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mach = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			mach[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(500, 0);
		
		System.out.println(ans);
	}
}

package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    
	static LinkedList<Integer>[] ll;
	static boolean[] visit;
	static int n,m;
	
	static boolean dfs(int now, int cnt) {
		//System.out.println("now: " + now + " cnt: " + cnt);
		if(cnt >= 5)
			return true;
		else {
			for(int i : ll[now]) {
				if(!visit[i]) {
					visit[i] = true;
					if(!dfs(i,cnt+1))
						visit[i] = false;
					else return true;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	ll = new LinkedList[n];
    	
    	for(int i =0; i<n; i++) {
    		ll[i] = new LinkedList<>();
    	}
    	
    	for(int i = 0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		ll[a].add(b);
    		ll[b].add(a);
    	}
    	
    	boolean b = false;
    	int ans = 0;
    	for(int i = 0; i<n-1; i++) {
        	visit = new boolean[n];
        	visit[i] = true;
    		if(dfs(i,1)) {
    			b = true;
    			break;
    		}
    	}
    	
    	
    	if(b) ans = 1;
    	
    	System.out.println(ans);
	}
}
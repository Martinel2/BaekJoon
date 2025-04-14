package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static int[] par;
	
	//union find + 사이클 판별
	static int find(int x) {
		if(par[x] == x) return x;
		else return find(par[x]); 
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(y < x) {
			int tmp = y;
			y = x;
			x = tmp;
		}
		if(x==y) par[x] = 0;
		else {
			par[y]=x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n,m;
		int cnt = 1;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		while(n !=0 || m!=0) {
			par = new int[n+1];
			for(int i=1; i<=n; i++) {
				par[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			
			
			HashSet<Integer> tree = new HashSet<>();
			for(int i=1; i<=n; i++) {
				int p = find(i);
				if(p > 0)
					tree.add(p);
			}
		
			int ans = tree.size();
			if(ans > 1) 
				sb.append("Case "+cnt+": A forest of ").append(ans).append(" trees.\n");
			else if(ans == 1)
				sb.append("Case "+cnt+": There is one tree.\n");
			else
				sb.append("Case "+cnt+": No trees.\n");
		
			
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			cnt++;
		}
		System.out.println(sb);
	}
}
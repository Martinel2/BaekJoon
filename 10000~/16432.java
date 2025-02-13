package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	static int[] ans;
    static ArrayList<Integer>[] dd;
    static int n;
    
	static void bfs(int now, int depth) {
		if(depth == n+1) return;
		for(int next : dd[depth]) {
			if(now != next) {
				ans[depth] = next;
				bfs(next, depth+1);
				if(ans[n] > 0) return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        dd = new ArrayList[n+1];
        
        for(int i =1; i<=n; i++) {
        	dd[i] = new ArrayList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	int type = Integer.parseInt(st.nextToken());
        	for(int j=0; j<type; j++) {
        		dd[i].add(Integer.parseInt(st.nextToken()));
        	}
        }
        
        ans = new int[n+1];
        
        for(int d : dd[1]) {
        	ans[1] = d;
        	bfs(d,2);
        	
        	if(ans[n] > 0) break;
        }
        
        if(ans[n] > 0)
	        for(int i=1; i<=n; i++) {
	        	System.out.println(ans[i]);
	        }
        else System.out.println(-1);
	}
}
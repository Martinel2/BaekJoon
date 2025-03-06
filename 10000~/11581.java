package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static ArrayList<Integer>[] link;
	static boolean[] stack;
	static boolean[] visit;
	
	static boolean cycle = false;

	
	static void dfs(int now) {
		//System.out.println(now);
		visit[now] = true;
		stack[now] = true;
		
		for(int next : link[now]) {
			if(next == n) continue;
			
			if(!visit[next] && !stack[next]) dfs(next);
			
			else if(stack[next]) {
				cycle = true;
				return;
			}	
		}

		stack[now] = false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        link = new ArrayList[n];
        stack = new boolean[n];
        visit = new boolean[n];
        
        for(int i=1; i<n; i++) {
        	link[i] = new ArrayList<>();
        	int m = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		int e = Integer.parseInt(st.nextToken());
        		link[i].add(e);
        	}
        }
        
        dfs(1);
        
        System.out.println(cycle? "CYCLE":"NO CYCLE");
        
    }
}
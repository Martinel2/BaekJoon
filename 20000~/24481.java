package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] v;
	static ArrayList<Integer>[] e;
	static boolean[] visited;
	static int[] depth;
	
	static void dfs(int r, int dep) {
		visited[r] = true;
		depth[r] = dep;
		for(int next : e[r]) {
			if(!visited[next]) dfs(next, dep+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        v = new int[n+1];
        e = new ArrayList[n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	depth[i] = -1;
        	e[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	e[a].add(b);
        	e[b].add(a);
        }
        
        for(int i=1; i<=n; i++) {
        	Collections.sort(e[i]);
        }
        
        dfs(r,0);
        
        for(int i=1; i<=n; i++) System.out.println(depth[i]);
    }
}
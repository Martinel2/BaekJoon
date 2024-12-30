package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        water = new int[n];
        ArrayList<Integer>[] link = new ArrayList[n];
        par = new int[n];
        
        
        for(int i=0; i<n; i++) {
        	link[i] = new ArrayList<>();
        	par[i] = i;
        }
                
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	water[i] = Integer.parseInt(st.nextToken()) ==1? 1:-1;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());        	
            int a = Integer.parseInt(st.nextToken())-1;       	
            int b = Integer.parseInt(st.nextToken())-1;
            
            link[a].add(b);
            link[b].add(a);
        }
        
        for(int i=0; i<n; i++) {
        	for(int e : link[i]) {
        		union(i,e);
        	}
        }
        
        //union find
        while(q-->0) {
        	int k = Integer.parseInt(br.readLine())-1;
        	//System.out.println(par[k]);
            int ans = water[find(k)] > 0? 1:0;
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
        
    }    
    
    static int[] par;
    static int[] water;
    static int find(int x) {
    	if(par[x] == x) return x;
    	
    	par[x] = find(par[x]);
    	return par[x];
    }
    
    static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if(x==y) return;
    	
    	if(x < y) {
    		par[y] = x;
    		water[x] += water[y]; 
    	}else {
    		par[x] = y;
    		water[y] += water[x];
    	}
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
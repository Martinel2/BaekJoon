package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    
	static ArrayList<Integer>[] arr,tree;
	static int[] parent,size;
	
	static void makeTree(int cur, int p) {
		for(int node : arr[cur]) {
			if(node != p) {
				tree[cur].add(node);
				parent[node] = cur;
				makeTree(node,cur);
			}
		}
	}
	
	static int countSubtreeNodes(int cur) {
		if(size[cur] == 0) {
			size[cur] = 1;
			for(int child : tree[cur]) {
				countSubtreeNodes(child);
				size[cur] += size[child];
			}
		}
		return size[cur];
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	
    	arr = new ArrayList[n+1];
    	tree = new ArrayList[n+1];
    	parent = new int[n+1];
    	size = new int[n+1];
    	for(int i = 1; i<=n; i++) {
    		arr[i] = new ArrayList<>();
    		tree[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0; i<n-1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		arr[a].add(b);
    		arr[b].add(a);
    	}
    	
    	makeTree(r,-1);
    	
    	
    	while(q-->0) {
    		int sub = Integer.parseInt(br.readLine());
    		sb.append(countSubtreeNodes(sub)).append('\n');
    	}
    	System.out.println(sb);
    }
}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		st = new StringTokenizer(br.readLine()); 
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] list = new LinkedList[n+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		for(int i = 1; i<=n; i++) {
			list[i] = new LinkedList<>();
		}
		
		int[] degree = new int[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			degree[b]++;
		}
		
		for(int i = 1; i<=n; i++) {
			if(degree[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int idx = pq.poll();
			sb.append(idx).append(' ');
			
			for(int val : list[idx]) {
				degree[val]--;
				if(degree[val] == 0)
					pq.add(val);
			}
		}
		
		System.out.println(sb);
	}
}
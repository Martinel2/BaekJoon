package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n,m;
		int[] visit = new int[100001];
		int[] parent = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit[n] = 1;
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.poll();
			//System.out.println(now+" "+cnt);
				if(now*2 <= 100000 && visit[now*2] == 0) {
					visit[now*2] = visit[now]+1;
					parent[now*2] = now;
					q.add(now*2);
				}if(now+1 <= 100000 && visit[now+1] == 0) {
					visit[now+1] = visit[now]+1;
					parent[now+1] = now;
					q.add(now+1);
				}if(0<= now-1 && visit[now-1] == 0) {
					visit[now-1] = visit[now]+1;
					parent[now-1] = now;
					q.add(now-1);
				}
			
			if(visit[m] != 0) break;
		}
		
		System.out.println(visit[m]-1);
		 Stack<Integer> s = new Stack<>();
	        int idx = m;
	        while (idx != n) {
	            s.push(idx);
	            idx = parent[idx];
	        }
	        s.push(idx);
	 
	        while (!s.isEmpty()) {
	            System.out.print(s.pop() + " ");
	        }
	}
}
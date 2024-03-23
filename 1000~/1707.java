package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			LinkedList<Integer>[] g = new LinkedList[v];
			int[] color = new int[v];
			boolean check = true;
			
			for(int i=0; i<v; i++) {
				g[i] = new LinkedList<>();
			}
			
			for(int i = 0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken())-1;
				int v2 = Integer.parseInt(st.nextToken())-1;
				
				g[v1].add(v2);
				g[v2].add(v1);
			}
			
			for(int i = 0; i<v; i++) {
				if(!check)
					break;
				
				if(color[i] == 0) {
					Queue<Integer> q = new LinkedList<>();
					q.add(i);
					color[i] = 1;
					
					while(!q.isEmpty()) {
						int vertex = q.poll();
						for(int ver : g[vertex]) {
							if(color[ver] == 0) {
								q.add(ver);
								color[ver] = color[vertex]*-1;
							}
							else if(color[ver] + color[vertex] != 0) {
								check = false;
								break;
							}
						}
					}
				}
			}
			String ans = check? "YES":"NO";
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
package bfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken())-1;
		
		boolean[] visit = new boolean[N];
		int[] ans = new int[N];
		int cnt = 1;
		ArrayList<Integer>[] e = new ArrayList[N];
		for(int i = 0; i<N; i++) {
			e[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			e[str].add(end);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		while(!q.isEmpty()) {
			int now = q.poll();
			ans[now] = cnt;
			cnt++;
			visit[now] = true;
			
			for(int val : e[now]) {
				if(!visit[val])
					q.add(val);
			}
		}
		
		for(int val : ans) {
			sb.append(val).append('\n');
		}
		System.out.print(sb);
	}
}

package card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		
		int cnt = 1;
		while(!q.isEmpty()) {
			for(int i = 0; i<cnt; i++) {
				int num = q.poll();
				q.add(num);
			}
			int idx = q.poll();
			arr[idx] = cnt;
			cnt++;
		}
		for(int i = 1; i<=N; i++) {
			sb.append(arr[i]).append(' ');
		}
		System.out.print(sb);
	}
}

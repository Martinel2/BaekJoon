package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+3];
		boolean[] che = new boolean[n+3];
		HashSet<Integer> sleep = new HashSet<>();
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			sleep.add(Integer.parseInt(st.nextToken()));
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<q; i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j=1; num*j<=n+2; j++) {
				if(sleep.contains(num*j)) {
					if(j == 1) break;
					continue;
				}
				che[num*j] = true;
			}
		}
		
		for(int i=3; i<=n+2; i++) {
			arr[i] = arr[i-1];
			if(!che[i]) arr[i]++;
			//System.out.println(arr[i]);
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(arr[end]-arr[str-1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
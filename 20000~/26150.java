package solved;

import java.util.*;
import java.io.*;

public class Main {
    
	static class P implements Comparable<P>{
		String s;
		int idx;
		int d;
		
		P(String s, int idx, int d){
			this.s=s;
			this.idx=idx;
			this.d=d;
		}
		
		@Override
		public int compareTo(P o) {
			return this.idx - o.idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		P[] arr = new P[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int idx = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[i] = new P(s,idx,d);
		}
		
		Arrays.sort(arr);
		
		for(P p : arr) {
			char c = p.s.charAt(p.d-1);
			if('a' <= c && c <= 'z') {
				c = (char)(c-32);
			}
			sb.append(c);
		}
		
		System.out.print(sb);
	}
}
package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			for(int i = 0; i<n; i++) {
				int max = 0;
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, Math.max(a, Math.max(b,c)));
				ans += max;
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
package security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n  = Integer.parseInt(br.readLine());
			String[] a = new String[n]; //1
			String[] b = new String[n]; //2
			
			String[] pw = new String[n];
			String[] ans = new String[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				a[i] = st.nextToken();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				b[i] = st.nextToken();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				pw[i] = st.nextToken();
			}
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(b[i].equals(a[j])) {
						ans[j] = pw[i];
						break;
					}
				}
			}
			
			for(String word : ans) {
				sb.append(word+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

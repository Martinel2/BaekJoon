package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int a,b;
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		sb.append(a/b+".");
		
		a = 10 * (a-b*(a/b));
		int t = 1500;
		while(t-->0) {
			sb.append(a/b);
			a = 10*(a-b*(a/b));
			
			if(a==0) break;
		}
		System.out.println(sb.toString());
	}
}

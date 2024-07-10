package solved;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n*5; i++) {
			if(i < n) {
				for(int j = 0; j<n*5; j++) {
					sb.append("@");
				}
				sb.append('\n');
			}
			else {
				for(int j = 0; j<n; j++) sb.append("@");
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
} 
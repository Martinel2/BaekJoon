package falseman;

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
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			char[] s = st.nextToken().toCharArray();
			
			for(int i = 0; i<s.length; i++) {
				if(i == a)
					continue;
				else
					sb.append(s[i]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

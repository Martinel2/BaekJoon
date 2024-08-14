package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		while(!s.equals("*")) {
			if(s.length() < 26) {
				sb.append("N\n");
			}
			else {
				int cnt = 0;
				boolean[] alpa = new boolean[26];
				s= s.replaceAll(" ", "");
				for(int i = 0; i<s.length(); i++) {
					int idx= s.charAt(i) - 'a';
					if(!alpa[idx]) {
						cnt++;
						alpa[idx] = true;
					}

					if(cnt == 26) {
						sb.append("Y\n");
						break;
								
					}
				}
				if(cnt < 26)
					sb.append("N\n");
			}
			s = br.readLine();
		}
		System.out.println(sb);
   }
}
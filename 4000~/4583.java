package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		while(!s.equals("#")) {
			int len = s.length();
			boolean m = true;
			String ans = "";
			for(int i = len-1; i>=0; i--) {
				char c = s.charAt(i);
				if(c == 'b') ans += "d";
				else if(c == 'd') ans += "b";
				else if(c == 'p') ans+= "q";
				else if(c == 'q') ans+= "p";
				else if(c == 'i' || c == 'o' || c == 'v'
						|| c == 'w' || c == 'x') ans += c;
				else {
					m = false;
					break;
				}
			}
			ans = m? ans:"INVALID";
			sb.append(ans).append('\n');
			s = br.readLine();
		}
		System.out.println(sb);
	}
}
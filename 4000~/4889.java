package solved;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int idx = 1;
		String s = br.readLine();
		while(!s.contains("-")) {
			int ans = 0;
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(!stack.isEmpty() && c == '}' && stack.peek()== '{') {
					stack.pop();
				}
				else
					stack.add(c);
			}	
			
			while(!stack.isEmpty()) {
				if(stack.peek() == '{') {
					ans++;
					stack.pop();
					if(stack.peek() == '{')
						stack.pop();
					else {
						ans++;
						stack.pop();
					}
				}
				else {
					stack.pop();
					char cc = stack.pop();
					if(cc == '}') ans++;
				}
			}
			sb.append(idx).append('.').append(' ').append(ans).append('\n');
			idx++;
			s= br.readLine();
		}
		System.out.println(sb);
	}
}

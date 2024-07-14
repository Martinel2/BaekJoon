package solved;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		Stack<Character> stack = new Stack<>();
		
		String s = br.readLine();
		int ans = 0;
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.add(c);
			}else {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					ans++;
				}
			}
		}
		ans += stack.size();
		
		System.out.println(ans);
	}
} 
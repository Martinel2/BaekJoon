package solved;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Character> stack = new Stack<>();
		
		String s = br.readLine();
		
		int left = 0;
		int right = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '@') stack.add(c);
			else if(c == '(') {
				left = stack.size();
				stack.clear();
			}
		}
		right = stack.size();
		
		System.out.println(left + " "+right);
	}
}
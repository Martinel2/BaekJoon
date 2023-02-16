import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
	
		String s = br.readLine();
	
		int len = s.length();
		boolean flag = true;
		for(int i = 0; i<len; i++) {
			if(i+1 < len && s.substring(i, i+2).equals("()")) {
				stack.push("2");
				i++;
			}
			else if(i+1 < len && s.substring(i, i+2).equals("[]")) {
				stack.push("3");
				i++;
			}
			else if(s.charAt(i) == '(') 
				stack.push("(");
			else if(s.charAt(i) == '[') 
				stack.push("[");
			else if(s.charAt(i) == ')' || s.charAt(i) == ']') {
				String open;
				int mul;
				int sum = 0;
				if(s.charAt(i) == ')') {
					open = "(";
					mul = 2;
				}
				else {
					open = "[";
					mul = 3;
				}
				
				while(!stack.isEmpty() && !stack.peek().equals("[") && !stack.peek().equals("(")) {
					sum += Integer.parseInt(stack.pop());
				}
				if(stack.isEmpty() || !stack.peek().equals(open))
					flag = false;
				else {
					stack.pop();
					stack.push(String.valueOf(sum*mul));
				}
			}
			if(!flag)
				break;
		}
		int ans = 0;
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(") || stack.peek().equals("[")) {
				flag = false;
				break;
			}
			else
				ans += Integer.parseInt(stack.pop());
		}
			
		if(flag)
			System.out.println(ans);
		else
			System.out.println("0");
	}
}

// (()[[]])([])
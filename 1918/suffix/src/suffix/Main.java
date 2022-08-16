package suffix;

import java.io.*;
import java.util.*;


//1918 후위표기식
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		HashSet<Character> op = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		//연산자 기록
		op.add('+');
		op.add('-');
		op.add('*');
		op.add('/');
		
		char[] s = br.readLine().toCharArray();//식 입력
		int i = 0;
		int len = s.length;
		while(i<len)
		{
			if(s[i] == '(')//괄호면 젤 먼저 처리
			{
				i++;
				while(s[i] != ')' )
				{
					if(op.contains(s[i]))
						stack.push(s[i]);
					else
						sb.append(s[i]);
					i++;
				}
				sb.append(stack.pop());
			}
			else if(op.contains(s[i]))//연산자이면
			{
				stack.push(s[i]);
			}
			else
			{
				sb.append(s[i]);
			}
			if(i > 0)
				if(op.contains(s[i-1]))
				{
					if(stack.peek() == '*' || stack.peek() == '/') {
						while(!stack.isEmpty())
							sb.append(stack.pop());
					}
				}
			i++;
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.print(sb);
	}
}
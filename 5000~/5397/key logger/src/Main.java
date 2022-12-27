import java.io.*;
import java.util.*;

//5397  Å°·Î°Å
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++) {
			String s = br.readLine();
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			int len = s.length();
			for(int i = 0; i<len; i++) {
				if(s.charAt(i) == '<') {
					if(!left.isEmpty()) {
						right.add(left.pop());
					}
				}
				else if(s.charAt(i) == '>') {
					if(!right.isEmpty()) {
						left.add(right.pop());
					}
				}
				else if(s.charAt(i) == '-') {
					if(!left.isEmpty()) {
						left.pop();
					}
				}
				else
					left.add(s.charAt(i));
			}
			while(!left.isEmpty())
				right.add(left.pop());
			while(!right.isEmpty())
				sb.append(right.pop());
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

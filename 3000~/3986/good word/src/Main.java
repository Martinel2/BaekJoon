import java.io.*;
import java.util.Stack;

//3986 좋은 단어
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j<s.length(); j++) {
				char word = 'C';
				if(!stack.isEmpty())
					word = stack.peek();
				if(word == s.charAt(j))
					stack.pop();
				else
					stack.add(s.charAt(j));
			}
			if(stack.isEmpty())
				ans++;
		}
		System.out.println(ans);
	}
}
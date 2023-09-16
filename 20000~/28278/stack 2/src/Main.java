import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//28278
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			char com = s.charAt(0);
			
			switch(com) {
			case '1':
				stack.add(s.charAt(2)-'0');
				break;
			case '2':
				if(!stack.isEmpty()) 
					sb.append(stack.pop()).append('\n');
				else 
					sb.append(-1).append('\n');
				break;
			case '3':
				sb.append(stack.size()).append('\n');
				break;
			case '4':
				if(stack.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case '5':
				if(!stack.isEmpty())
					sb.append(stack.peek()).append('\n');
				else
					sb.append(-1).append('\n');
				break;	
			}
		}
		
		System.out.println(sb);
	}
}

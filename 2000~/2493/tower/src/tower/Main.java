package tower;
import java.io.*;
import java.util.*;

//2493 ž
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(num <= stack.peek()[1]) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty())
				sb.append(0).append(" ");
			stack.push(new int[] {i, num});
		}
		System.out.println(sb);
	}
}
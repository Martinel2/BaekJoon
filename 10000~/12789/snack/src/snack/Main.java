package snack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		Stack<Integer> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(cnt == num) {
				cnt++;
			}
			else {
				while(!stack.isEmpty() && stack.peek() == cnt) {
					stack.pop();
					cnt++;
				}
				stack.add(num);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == cnt) {
				stack.pop();
				cnt++;
			}
			else break;
		}
		if(!stack.isEmpty())
			System.out.println("Sad");
		else
			System.out.println("Nice");
	}
}

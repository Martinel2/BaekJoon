package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Work {
		int score;
		int min;
		
		Work(int score, int min){
			this.score = score;
			this.min = min;
		}
		
		void one(){
			this.min--;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Work> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			if(n == 1) {
				int score = Integer.parseInt(st.nextToken());
				int min = Integer.parseInt(st.nextToken());
				stack.add(new Work(score,min));
			}
			
			if(!stack.isEmpty()) {
				Work w = stack.pop();
				w.one();
				if(w.min == 0) {
					ans += w.score;
				}
				else
					stack.add(w);
			}
		}
		
		System.out.println(ans);
	}
}

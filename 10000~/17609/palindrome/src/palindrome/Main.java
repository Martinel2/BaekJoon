package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class point{
		int front=0;
		int back=0;
		
		point(int front, int back){
			this.front = front;
			this.back = back;
		}
		
	}
	
	static char[] s;
	static boolean check(point P) {
		boolean palin = true;
		while(P.front <= P.back) {
			if(s[P.front] == s[P.back]) {
				P.front++;
				P.back--;
			}
			else{
				palin = false;
				break;
			}
		}
		return palin;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			s = br.readLine().toCharArray();
			
			int front = 0;
			int back = s.length-1;
			point P = new point(front,back);
			if(check(P))
				sb.append("0\n");
			else {
				if(check(new point(P.front+1,P.back)) || check(new point(P.front,P.back-1)))
					sb.append("1\n");
				else
					sb.append("2\n");
			}
		}
		System.out.println(sb);
	}
}

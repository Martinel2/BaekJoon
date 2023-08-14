package arena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean solve(char[] s) {
		int N = s.length;
		if(s[0] == '*' || s[N-1] == '*') {
			int cnt = 0;
			for(int i = 0; s[i] != '*'; ++i) {
				if(s[i] == ')') 
					cnt--;
				else
					cnt++;
				if(cnt < 0)
					return false;
			}
			cnt = 0;
			for(int i = N-1; s[i] != '*'; --i) {
				if(s[i] == '(') 
					cnt--;
				else
					cnt++;
				if(cnt < 0)
					return false;
			}
			return true;
		}
		if(N%2 !=0)
			return false;
		int open = 0;
		int close = 0;
		for(int i = 0; i<N; i++) {
			if(s[i] == '(')
				open++;
			else if(s[i] == ')')
				close++;
		}
		if(open > N/2 || close > N/2)
			return false;
		
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(s[i] == '?')
			{
				if(open < N/2) {
					s[i] = '('; 
					open++;
				}
				else
					s[i] = ')';
			}
			if(s[i] == '(')
				cnt++;
			else
				cnt--;
			if(cnt < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			char[] s;
			s = br.readLine().toCharArray();
			sb.append(solve(s) ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}

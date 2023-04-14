package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//25501
public class Main {
	
	static int cnt = 0;
	
	static int recursion(char[] s, int l, int r) {
		cnt++;
		if(l>=r) return 1;
		else if(s[l] != s[r]) return 0;
		else return recursion(s, l+1, r-1);
	}
	
	static int isPalindrome(char[] s) {
		return recursion(s,0,s.length-1);
	}
	
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			cnt = 0;
			char[] s = br.readLine().toCharArray();
			sb.append(isPalindrome(s)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}

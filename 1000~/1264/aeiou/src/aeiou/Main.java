package aeiou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Character> aeiou = Set.of('a','e','i','o','u','A','E','I','O','U');
		
		String s = br.readLine();
		while(!s.equals("#")) {
			int cnt = 0;
			for(int i = 0; i<s.length(); i++) {
				if(aeiou.contains(s.charAt(i)))
					cnt++;
			}
			sb.append(cnt).append("\n");
			s = br.readLine();
		}
		System.out.println(sb);
	}
}

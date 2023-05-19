package energram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] first = new int[26];
		int[] second = new int[26];
		int cnt = 0;
		String s1 = br.readLine();
		String s2 = br.readLine();
	
		for(int i = 0; i<s1.length(); i++) 
			first[s1.charAt(i)-'a'] += 1;
		
		for(int i = 0; i<s1.length(); i++) 
			second[s2.charAt(i)-'a'] += 1;
		
		for(int i = 0; i<26; i++) {
			cnt += Math.abs(first[i] - second[i]);
		}
		System.out.println(cnt);
	}
}

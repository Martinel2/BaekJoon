package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> a = new HashSet<>();
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			int[] alpa = new int[26];
			for(int j = 0; j<s.length(); j++) {
				alpa[s.charAt(j)-'a']++;
			}
			String save = "";
			for(int j = 0; j<26; j++) {
				save += String.valueOf(alpa[j]);
			}
			a.add(save);
		}
		
		System.out.println(a.size());
	}
}

package basketball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] alpa = new int[26];
		for(int i = 0; i<N; i++) {
			String player = br.readLine();
			alpa[player.charAt(0)-'a']++;
		}
		for(int i = 0; i<26; i++) {
			if(alpa[i] >= 5)
				sb.append((char)('a'+i));
		}
		if(sb.length() == 0)
			System.out.println("PREDAJA");
		else
			System.out.println(sb);
	}
}

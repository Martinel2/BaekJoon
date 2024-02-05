package password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<String> dic = new HashSet<>();
		
		String s = br.readLine();
		String ans = "";
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			dic.add(br.readLine());
		}
		
		for(int i = 1; i<=26; i++) {
			String b = "";
			boolean key = false;
			for(int j = 0; j<s.length(); j++) {
				b += (char)('a' + (s.charAt(j)-'a' +i)%26);
			}
			//System.out.println(b);
			for(String word : dic) {
				if(b.contains(word)) {
					key = true;
					break;
				}
			}
			if(key) {
				ans = b;
				break;
			}
		}
		
		System.out.println(ans);
	}
}

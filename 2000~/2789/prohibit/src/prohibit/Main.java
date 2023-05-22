package prohibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Character> prohibit = Set.of('C','A','M','B','R','I','D','G','E');
		
		String S = br.readLine();
		String ans = "";
		for(int i = 0; i<S.length(); i++) {
			if(!prohibit.contains(S.charAt(i)))
				ans += S.charAt(i);
		}
		System.out.println(ans);
	}
}

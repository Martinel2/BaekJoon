package solved;

import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int ans = 1;
		for(int  i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == 'c') {
				if(i > 0 && c == s.charAt(i-1)) {
					ans *= 25;
				}
				else {
					ans *= 26;
				}
			}
			if(c == 'd') {
				if(i > 0 && c == s.charAt(i-1)) {
					ans *= 9;
				}
				else {
					ans *= 10;
				}
			}
		}
		System.out.println(ans);
	}
}
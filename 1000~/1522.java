package solved;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//StringBuilder sb= new StringBuilder();
		
		//문자열에서 i번째 문자와 j번째문자가 자리를 바꾼다
		
		String s = br.readLine();
		
		int a = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a') a++;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<s.length(); i++) {
			int b =0;
			for(int j=i; j<i+a; j++) {
				int idx = j%s.length();
				if(s.charAt(idx) == 'b') b++;
			}
			ans = Math.min(ans, b);
		}
		System.out.println(ans);
	}
}
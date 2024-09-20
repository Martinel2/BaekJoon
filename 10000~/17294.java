package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		String s = br.readLine();
		boolean cute = true;
		if(s.length() > 2) {
			int d = (s.charAt(1)-'0') - (s.charAt(0)-'0');
			int bef = s.charAt(1)-'0';
			for(int i = 2; i<s.length(); i++) {
				int num = s.charAt(i)- '0';
				if(d != num-bef) {
					cute = false;
					break;
				}
				bef = num;
			}
		}
		String ans = cute? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!":"흥칫뿡!! <(￣ ﹌ ￣)>";
		System.out.println(ans);
	}
}
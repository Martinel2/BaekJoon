package plate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char bef = s.charAt(0);
		int cnt = 10;
		for(int i = 1; i<s.length(); i++) {
			if(s.charAt(i) == bef)
				cnt += 5;
			else {
				cnt += 10;
				bef = s.charAt(i);
			}
		}
		System.out.println(cnt);
	}
}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int ans = 0;
		String s = br.readLine();
		s = s.replaceAll("pPAp", "C");
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == 'C') ans++;
		}
		
		System.out.println(ans);
    }
}
package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Character,String> hm = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String pat = st.nextToken();
			char up = st.nextToken().charAt(0);
			hm.put(up, pat);
		}
		
		char[] s = br.readLine().toCharArray();
		String plain = "";
		for(char upper: s) {
			plain += hm.get(upper);
		}
		
		int a,b;
		st = new StringTokenizer(br.readLine());
		a= Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		System.out.println(plain.substring(a-1,b));
    }
}
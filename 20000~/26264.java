package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		s = s.replaceAll("security", "A");
		s = s.replaceAll("bigdata", "B");
		
		int big = 0;
		int sec = 0;
		for(int i = 0; i<n; i++) {
			if(s.charAt(i) == 'A')
				sec++;
			else
				big++;
		}
		
		String ans = "";
		if(big > sec) ans = "bigdata?";
		else if(big == sec) ans = "bigdata? security!";
		else ans = "security!";
		
		System.out.println(ans);
	}
}
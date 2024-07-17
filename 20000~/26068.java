package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			s= s.substring(2);
			int num = Integer.parseInt(s);
			if(num <= 90)
				ans++;
		}
		System.out.println(ans);
		
	}
}
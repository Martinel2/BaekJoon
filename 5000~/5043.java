package solved;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String ans = "";
		st = new StringTokenizer(br.readLine());
		long n,b;
		n = Long.parseLong(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if(n <= Math.pow(2,b+1)-1) {
			ans = "yes";
		}
		else
			ans = "no";
		
		System.out.println(ans);
	}
} 
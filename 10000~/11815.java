package solved;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(t-->0) {
			int ans = 0;
			BigInteger n = new BigInteger(st.nextToken());
			if (n.sqrt().pow(2).equals(n)) {
	            ans = 1;
	        } else {
	            ans = 0;
	        }
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}
}
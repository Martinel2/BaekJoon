package solved;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		
		String s = Integer.toBinaryString(k);
		int len = s.length();
		int min = 0;
		int bcnt = Integer.bitCount(k);
		
		if(bcnt > 1) {
			min = (int)Math.pow(2, len);
			int cnt = 0;
			while(bcnt > 0) {
				if(s.charAt(cnt) == '1') bcnt--;
				cnt++;
			}
			bcnt = cnt;
		}
		else {
			min = (int)Math.pow(2, len-1);
			bcnt = 0;
		}
		
		
		System.out.println(min + " "+bcnt);
	}
}
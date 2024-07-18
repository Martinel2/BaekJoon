package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int chick = 0;
		for(int i = 0; i<n; i++) {
			if(s.charAt(i) == 'C') {
				chick++;
			}
		}
		System.out.println(chick/(n-chick+1) + (chick%(n-chick+1)!=0?1:0));
	}
}
package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashSet<Long> hs = new HashSet<>();
		hs.add((long) 0);
		int n = Integer.parseInt(br.readLine());
		
		
		long pre = 0;
		for(int i=1; i<=n; i++) {
			if(pre - i < 0 || hs.contains(pre - i)) {
				hs.add(pre + i);
				pre = pre+i;
			}else {
				hs.add(pre-i);
				pre -= i;
			}
		}
		
		System.out.println(pre);
	}
	
}
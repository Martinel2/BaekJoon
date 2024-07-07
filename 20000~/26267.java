package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Long> hm = new HashMap<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			hm.put(x-c, hm.getOrDefault(x-c, (long) 0)+m);
		}
		long ans = 0;
		for(long val : hm.values()) {
			ans = Math.max(val, ans);
		}
		System.out.println(ans);
	}
}
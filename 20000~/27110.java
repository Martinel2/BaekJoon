package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int ans= 0; 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			ans += Math.min(n, Integer.parseInt(st.nextToken()));
		}
		System.out.println(ans);
	}	
}

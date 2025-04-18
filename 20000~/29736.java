package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int x= Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i=a; i<=b; i++) {
			int num = Math.abs(k-i);
			if(num <= x) ans++;
		}
		
		if(ans == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
	}
}
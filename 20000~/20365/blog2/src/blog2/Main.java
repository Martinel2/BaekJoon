package blog2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int bcnt = 0;
		for(int i = 0; i<n; i++) {
			if(s.charAt(i) == 'B')
				bcnt++;
		}
		int rcnt = n-bcnt;
		
		int ans = Math.min(rcnt, bcnt) + 1;
		System.out.println(ans);
	}
}

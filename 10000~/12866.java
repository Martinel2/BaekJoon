package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int n =Integer.parseInt(br.readLine());
		String s = br.readLine();
		long[] cnt = new long[4];
		for(int i =0; i<n; i++) {
			char c = s.charAt(i);
			if(c == 'A') cnt[0]++;
			else if(c=='C') cnt[1]++;
			else if(c=='G') cnt[2]++;
			else cnt[3]++;
		}
		int mod = 1000000007;
		long ans = (cnt[0]*cnt[1])%mod;
		ans = (ans*cnt[2])%mod;
		ans = (ans*cnt[3])%mod;
		System.out.println(ans);
	}
}
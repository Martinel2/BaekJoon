package solved;

import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		String s = br.readLine();
		int[] sum = new int[s.length()];
		sum[0] = s.charAt(0) - '0';
		for(int i=1; i<s.length(); i++) {
			int num = s.charAt(i) - '0';
			sum[i] = sum[i-1] + num;
		}
		
		int ans = 0;
		for(int i =0; i<s.length(); i++) {
			int l = 0;
			for(int j = i+1; j<s.length(); j+=2) {
				if(i==0 && sum[i+l] == sum[j]-sum[j-l-1]) {
					ans = Math.max(ans, j-i+1);
				}
			    else if(i> 0 && sum[i+l]-sum[i-1] == sum[j]-sum[j-l-1]) {
					//System.out.println(i+" "+j+" "+(sum[i+1]-sum[i-1]) + " "+ (sum[j]-sum[j-l-1]));
					ans = Math.max(ans, j-i+1);
				}
				l++;
			}
		}
		System.out.println(ans);
	}
}
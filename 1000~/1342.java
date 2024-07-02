package solved;

import java.util.*;
import java.io.*;

public class Main{
	static int ans = 0;
	static int[] alpa = new int[27];
	static int len=0;
	static void backtracking(int idx, char prev) {
		if(idx == len) {
			ans++;
			return;
		}
		for(int i = 0; i<27; i++) {
			if(alpa[i] == 0) continue;
			
			else if((char)(i+'a') != prev) {
				alpa[i]--;
				backtracking(idx+1,(char)(i+'a'));
				alpa[i]++;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		String s = br.readLine();
		len = s.length();
		for(int i = 0; i<len; i++) {
			alpa[s.charAt(i) - 'a']++;
		}
		backtracking(0,' ');
		System.out.println(ans);
	}
}
package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static String ans = "";
	static void bt(int cnt, String s) {
		//System.out.println(s);
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j-i == 1) return;
					for(int k=1; i+k<j && j+k<s.length(); k++) {
						if(s.charAt(i+k) != s.charAt(j+k)) break;
						if(k == j-i-1) return;
					}
				}
			}
		}
		
		if(cnt==0) {
			ans = s;
			return;
		}
		for(int i=1; i<=3; i++) {
			char c = (char) ('0' + i);
			bt(cnt-1, s+c);
			if(!ans.equals("")) return;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        bt(n,"");
        System.out.println(ans);
    }
}
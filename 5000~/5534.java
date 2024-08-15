package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		char[] name = br.readLine().toCharArray();
		int ans = 0;
		
		for(int i = 0; i<n; i++) {
			String old = br.readLine();
			int len = old.length();
			Loop:for(int str=0; str<len; str++) {
				if(old.charAt(str) != name[0]) continue;
				
				for(int end = str; end < len; end++) {
					if(old.charAt(end) != name[name.length-1]) continue;
					
					int gap = (end-str)/(name.length-1);
					int cnt = 0;
					while(cnt < name.length) {
						if(old.charAt(str+gap*cnt) == name[cnt]) cnt++;
						else break;
					}
					if(cnt == name.length) {
						ans++;
						break Loop;
					}
				}
			}
		}
		System.out.println(ans);
   }
}
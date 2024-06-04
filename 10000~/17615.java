package solved;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		char[] ball = br.readLine().toCharArray();
		
		int blue = 0;
		int red = 0;
		int cnt = 0;
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			if(ball[i] == 'B') blue = 1;
			if(blue == 1 && ball[i] == 'R') cnt++;
		}
		ans = Math.min(ans, cnt);
		cnt = 0;
		blue = 0;
		for(int i = n-1; i>=0; i--) {
			if(ball[i] == 'B') blue = 1;
			if(blue == 1 && ball[i] == 'R') cnt++;
		}
		ans = Math.min(ans, cnt);
		cnt = 0;
		blue = 0;
		
		for(int i = 0; i<n; i++) {
			if(ball[i] == 'R') red = 1;
			if(red == 1 && ball[i] == 'B') cnt++;
		}
		ans = Math.min(ans, cnt);
		cnt = 0;
		red = 0;
		for(int i = n-1; i>=0; i--) {
			if(ball[i] == 'R') red = 1;
			if(red == 1 && ball[i] == 'B') cnt++;
		}
		ans = Math.min(ans, cnt);
		cnt = 0;
		red = 0;
		
		System.out.println(ans);
	}
}

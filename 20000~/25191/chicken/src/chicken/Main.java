package chicken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int chicken = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int coke = Integer.parseInt(st.nextToken());
		int beer = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		while(chicken != 0 && (coke >=2 || beer >= 1) ) {
			if(coke >= 2) {
				chicken--;
				coke -=2;
				ans++;
			}
			else {
				chicken--;
				beer--;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}

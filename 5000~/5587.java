package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] card = new int[2*n+1];
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			card[num] = 1;
		}
		
		int sang = 0;
		int g = 0;
		int put = 0;
		while(sang < n && g < n) {
			boolean sangput = false;
			for(int i = 1; i<=2*n; i++) {
				if(card[i] == 1 && put < i) {
					put = i;
					card[i] = -1;
					sang++;
					sangput = true;
					break;
				}
			}
			if(sang == n) break;
			if(!sangput) {
				put = 0;
			}
			boolean gput = false;
			for(int i = 1; i<=2*n; i++) {
				if(card[i] == 0 && put < i) {
					put = i;
					card[i] = -1;
					g++;
					gput = true;
					break;
				}
			}
			if(!gput) {
				put = 0;
			}
		}
		
		sang = 0;
		g = 0;
		
		for(int i = 1; i<=2*n; i++) {
			if(card[i] == 1)
				g++;
			else if(card[i] == 0)
				sang++;
		}
		System.out.println(sang);
		System.out.println(g);
	}
	
	// 1 6 2 3 4 5 8 7  
}
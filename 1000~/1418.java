package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int k = Integer.parseInt(br.readLine());
		
		int ans = n;
		int[] che = new int[n+1];

		for(int i = 2; i<=n; i++) {
			if(che[i] == 0) {
				if(i > k) {
					for(int j = 1; i*j<=n; j++) {
						if(che[i*j] != -1) {
							che[i*j] = -1;
							ans--;
						}
					}
				}
				else {
					for(int j = 2; i*j<=n; j++) {
						che[i*j] = 1;
					}
				}
				
			}
		}

		System.out.println(ans);
	}
}

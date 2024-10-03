package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		//1
		//00 01 11 = 3
		
		//2
		//00 01 11 02 21 22 
		//= 3 + 2*3 + (1+2)
		
		//3
		//00 01 11 02 21 22 03 31 32 33 
		//= 3 + 2*3 + (1+2) + 3*4 + (1+2+3)
		
		//4
		//00 01 11 02 21 22 03 31 32 33 04 41 42 43 44
		//= 3 + 2*3 + (1+2) + 3*4 + (1+2+3) + 4*5 + (1+2+3+4)
		
		// a0 = 0, an+1 = an + n*n+1 + n*(n+1)/2
		
		int ans = 3;
		
		for(int i = 2; i<=n; i++) {
			ans += i*(i+1) + (i*(i+1))/2;
		}
		
		System.out.println(ans);
	}
}
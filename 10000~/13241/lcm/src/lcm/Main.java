package lcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long A,B;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		//gcd(A,B) (A>B) == gcd(B,A%B)
		long a,b;
		if(A < B) {
			a = B;
			b = A;
		}
		else {
			a = A;
			b = B;
		}
		
		while(b >= 1) {
			long c = a%b;
			a = b;
			b = c;
			//System.out.println(a+" "+b);
		}
		System.out.println((A*B)/a);
	}
}

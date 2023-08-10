package div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		double A,B;
		int N;
		
		A = Double.parseDouble(st.nextToken());
		B = Double.parseDouble(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		double res = A%B;
		
		for(int i=1; i<N;i++) {
			res *= 10;
			res %= B;
		}

		System.out.println( (int)((res/B)*10) );
		
	}
}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 1 1 2 1 1 2 1 = 9
		// 1 0 0 0 0 1 = 2
		// 2 1 1 2 1 = 7
		// 0 0 0 2 
		// 0 0 1
		// 0 1
		// 2
		// = 24
		
		long n = Long.parseLong(br.readLine());
		long zero = 0;
		long one = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) zero++;
			else if(num == 1) one++;
		}
		
		long sum = 0;
		sum += (zero-1)*(zero)/2;
		sum += zero*one*2;
		sum += zero*(n-zero-one);
		System.out.println(sum);
	}
}
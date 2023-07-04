package gangho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] person = new int[N];
		
		for(int i = 0; i<N; i++) {
			person[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(person);
		
		long ans = 0;
		for(int i = N-1; i>=0; i--) {
			int tip = person[i] - ((N-i)-1);
			if(tip > 0)
				ans += tip;
		}
		System.out.println(ans);
	}
}

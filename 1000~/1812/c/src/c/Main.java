package c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sum = new int[N];
		
		for(int i = 0; i<N; i++) {
			sum[i] = Integer.parseInt(br.readLine());
		}
		
		int[] res = new int[N];
		
		int s = 0;
		for(int i = 0; i<N; i++) {
			if(i % 2 != 0) {
				s -= sum[i];
			}
			else
				s += sum[i];
		}
		
		res[0] = s/2;
		for(int i = 1; i<N; i++) {
			res[i] = sum[i-1] - res[i-1];
		}
		
		for(int var : res) {
			System.out.println(var);
		}
	}
}

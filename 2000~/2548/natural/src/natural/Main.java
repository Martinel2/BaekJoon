package natural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int num = 0;
		
		for(int i = 1; i<20000; i++) {
			int sum = 0;
			for(int j = 0; j<N; j++) {
				sum += Math.abs(i - arr[j]);
			}
			if(sum < min) {
				min = sum;
				num = i;
			}
			else break;
		}
		
		System.out.println(num);
	}
}
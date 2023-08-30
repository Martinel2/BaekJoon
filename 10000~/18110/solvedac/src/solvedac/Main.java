package solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int del = (int)Math.floor((n*0.15)+0.5);
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = (int)del; i<n-del; i++) {
			ans += arr[i];
		}
		double x = (double)ans / (n-(2*del));
		ans = (int)Math.floor(x+0.5);
		System.out.println(ans);
	}
}

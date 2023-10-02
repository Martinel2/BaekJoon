package seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[] score = new double[N];
		
		for(int i = 0; i<N; i++) {
			score[i] = Double.parseDouble(br.readLine());
		}
		
		Arrays.sort(score);
		
		for(int i = 0; i<7; i++) {
			System.out.printf("%.3f\n", score[i]);
		}
	}
}

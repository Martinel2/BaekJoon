package grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] grade = new int[N];
		
		for(int i = 0; i<N; i++) {
			grade[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(grade);
		
		long ans = 0;
		for(int i = 0; i<N; i++) {
			ans += Math.abs(grade[i] - (i+1));
		}
		
		System.out.println(ans);
	}
}

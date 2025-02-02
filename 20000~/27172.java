package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());

		int[] c = new int[n+1];
		int[] idx = new int[1000001];
		int[] score = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			idx[c[i]] = i;
		}
		
		for(int i=1; i<=n; i++) {
			for(int ind = c[i]*2; ind<=1000000; ind += c[i]) {
				if(idx[ind] >= 1) {
					score[idx[ind]]--;
					score[i]++;
				}
			}
		}
		for(int i=1; i<=n; i++) {
			System.out.print(score[i] + " ");
		}
	}
}
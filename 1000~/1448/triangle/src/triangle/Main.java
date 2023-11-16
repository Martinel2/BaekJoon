package triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] strow = new int[N];
		
		for(int i = 0; i<N; i++) {
			strow[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(strow);
		
		int ans = -1;
		
		for(int i = N-1; i>=2; i--) {
			if(strow[i] < strow[i-1] + strow[i-2]) {
				ans = strow[i] + strow[i-1] + strow[i-2];
				break;
			}
		}
		
		System.out.println(ans);
		
	}
}

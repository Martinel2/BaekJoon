package pasta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//25214
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int min;
		
		int[] dp = new int[n];
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		min = arr[0];
		
		for(int i = 1; i<n; i++) {
			dp[i] = Math.max(dp[i-1], arr[i] - min);
			if(arr[i] < min)
				min = arr[i];
		}
		
		for(int val : dp) {
			System.out.print(val+" ");
		}
	}
}

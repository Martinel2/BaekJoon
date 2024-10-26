package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int ans = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = m; i<=n; i++) {
			int sum = arr[i] - arr[i-m];
			ans = Math.max(sum,ans);
		}
		System.out.println(ans);
	}
	
}
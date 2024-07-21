package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n,d;
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[300001];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
			max = Math.max(max, num);
		}
		
		while(d-->0 && max != 0) {
			ans += arr[max];
			arr[max-1] += arr[max];
			max--;
		}
		System.out.println(ans);
	}
}
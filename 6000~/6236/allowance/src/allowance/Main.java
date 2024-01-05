package allowance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,m;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		long sum = 0;
		long max = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if(max < arr[i])
				max = arr[i];
		}
		
		long left = max;
		long right = sum;
		long res = 10000;
		while(left <= right) {
			long mid = (left + right)/2;
			long s = mid;
			int cnt = 0;
			for(int i = 0; i<n; i++) {
				if(s < arr[i]) {
					cnt++;
					s = mid;
				}
				s -= arr[i];
			}
			if(cnt <= m) { 
				right = mid - 1;
				if(res > mid)
					res = mid;
			}
			else
				left = mid + 1;
		}
		
		System.out.println(res);
	}
}

/*
7 5
100
400
300
100
500
101
400
*/
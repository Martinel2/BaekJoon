package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-->0) {
			long n = Long.parseLong(br.readLine());
			long left = 1;
			long right = 1000000000;
			long ans = 0;
			while(left<=right) {
				long mid = (left+right)/2;
				long sum = (mid*(mid+1))/2;
				if(sum <= n) {
					ans = Math.max(ans, mid);
					left = mid + 1;
				}
				else right = mid-1;
			}

			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}

package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n*2];
			int[] ans = new int[n];
			for(int j = 0; j<n*2; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int idx = n-1;
			for(int j = n*2-1; j>=0; j--) {
				int p = (int) (arr[j]*(0.75));
				//System.out.println(p);
				for(int k = 0; k<j; k++) {
					if(arr[k] == p) {
						ans[idx] = arr[k];
						arr[k] = -1;
						idx--;
						break;
					}
					if(arr[k] > p) break;
				}
			}
			sb.append("Case #").append(i).append(": ");
			for(int j = 0; j<n; j++) {
				sb.append(ans[j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}